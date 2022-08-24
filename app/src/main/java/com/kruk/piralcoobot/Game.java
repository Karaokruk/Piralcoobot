package com.kruk.piralcoobot;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.playerType.PlayerTypeData;
import com.kruk.piralcoobot.rules.*;


import static com.kruk.piralcoobot.R.*;

public class Game extends Fragment {

    private static boolean dataHasBeenRetrieved = false;

    private static int nbMinGulps = 0;
    private static int nbMaxGulps = 0;

    private static ArrayList<Rule> ruleSet = new ArrayList<>();

    private static PlayerTypeData pirateType;
    private static PlayerTypeData mousseType;
    private static PlayerTypeData guestType;

    private Rule currentRule;
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static int nbPlayers = 0;
    private static ArrayList<Player> pirates = new ArrayList<Player>();
    private static int nbPirates = 0;
    private static ArrayList<Player> mousses = new ArrayList<Player>();
    private static int nbMousses = 0;
    private static ArrayList<Player> guests = new ArrayList<Player>();
    private static int nbGuests = 0;

    private Rule getRandomRule() {
        return this.ruleSet.get(getRandomID(this.ruleSet.size()));
    }

    public static int getRandomID(int max) {
        int randomID = Math.round((float) Math.random() * max);
        return (randomID < max) ? randomID : 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(layout.game_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (dataHasBeenRetrieved) {
            Log.d("DEBUG", "Data has been loaded. Playing...");
        } else {
            Log.d("DEBUG", "No players loaded. Initializing...");
            try {
                retrievePlayerTypeData();
                retrieveRuleSetDataFromJson();
                retrievePlayers();
                dataHasBeenRetrieved = true;
            } catch(Exception e) {
                Log.d("ERROR", "Could not initialize game data.");
                e.printStackTrace();
            }
        }

        view.findViewById(id.button_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Game.this)
                        .navigate(id.action_gameFragment_to_self);
            }
        });

        // Receive gulps /!\ TODO
        nbMinGulps = 2;
        nbMaxGulps = 6;

        // Select random rule
        currentRule = getRandomRule();
        ConstraintLayout layout = view.findViewById(id.gameLayout);
        Log.d("DEBUG", currentRule.getClass().getName());
        layout.setBackgroundColor(getResources().getColor(currentRule.getRuleColorId()));

        TextView ruleTextView = view.findViewById(id.ruleId);

        // Select random players
        ArrayList<Player> selectedPlayers = new ArrayList<>();
        for (int i = 0; i < currentRule.getNbPlayers(); i++) {
            Player selectedPlayer;
            PlayerType playerTypeName = currentRule.getPlayerType(i);
            if (playerTypeName == pirateType.getPlayerType())
                selectedPlayer = this.pirates.get(getRandomID(nbPirates));
            else if (playerTypeName == mousseType.getPlayerType())
                selectedPlayer = this.mousses.get(getRandomID(nbMousses));
            else if (playerTypeName == guestType.getPlayerType())
                selectedPlayer = this.guests.get(getRandomID(nbGuests));
            else
                selectedPlayer = this.players.get(getRandomID(nbPlayers));
            selectedPlayers.add(selectedPlayer);
        }

        if (currentRule.hasGulps()) {
            int nbGulps = Math.round((float) Math.random() * (nbMaxGulps - nbMinGulps)) + nbMinGulps;
            switch (currentRule.getNbPlayers()) {
                case 0:
                    ruleTextView.setText(currentRule.getRuleText(nbGulps));
                    break;
                case 1:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).getName(), nbGulps));
                    break;
                case 2:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).getName(), selectedPlayers.get(1).getName(), nbGulps));
                    break;
                default:
                    ruleTextView.setText(currentRule.getRuleText());
            }
        } else {
            switch (currentRule.getNbPlayers()) {
                case 1:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).getName()));
                    break;
                case 2:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).getName(), selectedPlayers.get(1).getName()));
                    break;
                default:
                    ruleTextView.setText(currentRule.getRuleText());
            }
        }
    }

    private void retrievePlayers() {
        Log.d("DEBUG", "Retrieving players...");
        NavDestination context = NavHostFragment.findNavController(Game.this).getGraph().findNode(id.gameFragment);
        String key = "players";
        ArrayList<String> players = ((Bundle) context.getArguments().get(key).getDefaultValue()).getStringArrayList(key);

        for (String player : players) {
            String[] playerPackage = player.split(":");
            String playerName = playerPackage[0];
            String playerTypeName = playerPackage[1];

            Player newPlayer = null;
            if (playerTypeName.equals(pirateType.getName())) {
                newPlayer = new Player(playerName, PlayerType.PIRATE);
                this.pirates.add(newPlayer);
                nbPirates++;
            } else if (playerTypeName.equals(mousseType.getName())) {
                newPlayer = new Player(playerName, PlayerType.MOUSSE);
                this.mousses.add(newPlayer);
                nbMousses++;
            } else if (playerTypeName.equals(guestType.getName())) {
                newPlayer = new Player(playerName, PlayerType.GUEST);
                this.guests.add(newPlayer);
                nbGuests++;
            }
            if (newPlayer != null) {
                this.players.add(newPlayer);
                nbPlayers++;
            }
        }
        Log.d("DEBUG", "Players successfully retrieved.");
    }

    private void retrieveRuleSetDataFromJson() {
        Log.d("DEBUG", "Retrieving rule set data...");

        Gson gson = new Gson();
        // Retrieve source JSON
        Field[] fields = R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++)
        {
            Log.d("DEBUG", "Retrieving JSON resource ID...");
            int resourceId = 0;
            try {
                resourceId = fields[i].getInt(fields[i]);
                Log.d("DEBUG", "Successfully retrieved JSON resource with ID: " + resourceId + ".");
            } catch (IllegalAccessException e) {
                Log.d("DEBUG", "Failed to retrieve JSON resource ID.");
                e.printStackTrace();
            }
            InputStream ruleInputStream = getResources().openRawResource(resourceId);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int j = ruleInputStream.read();
                while (j != -1) {
                    byteArrayOutputStream.write(j);
                    j = ruleInputStream.read();
                }
                ruleInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Instantiate Rule class
            String ruleJsonString = byteArrayOutputStream.toString();
            Rule rule = gson.fromJson(ruleJsonString, Rule.class);

            ruleSet.add(rule);
        }

        Log.d("DEBUG", "Rule set data retrieved.");
    }

    private void retrieveRuleSetData() {
        Log.d("DEBUG", "Retrieving rule set data...");
        File file = new File(this.getContext().getFilesDir(), getResources().getString(string.ruleSetDataFile));

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            this.ruleSet = (ArrayList<Rule>) ois.readObject();
            Log.d("DEBUG", String.valueOf(this.ruleSet.size()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void retrievePlayerTypeData() {
        Log.d("DEBUG", "Retrieving player type data...");
        File file = new File(this.getContext().getFilesDir(), getResources().getString(R.string.playerTypeDataFile));

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<PlayerTypeData> playerTypeData = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            playerTypeData = (ArrayList<PlayerTypeData>) ois.readObject();
            for (PlayerTypeData p : playerTypeData) {
                Log.d("DEBUG", p.getName());
                switch (p.getName()) {
                    case "Pirate":
                        this.pirateType = p;
                        break;
                    case "Mousse":
                        this.mousseType = p;
                        break;
                    case "Guest":
                        this.guestType = p;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

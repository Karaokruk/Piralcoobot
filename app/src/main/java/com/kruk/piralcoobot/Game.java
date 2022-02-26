package com.kruk.piralcoobot;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

import com.kruk.piralcoobot.playerType.GuestType;
import com.kruk.piralcoobot.playerType.MousseType;
import com.kruk.piralcoobot.playerType.PirateType;
import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.*;
import com.kruk.piralcoobot.rules.deathRules.*;
import com.kruk.piralcoobot.rules.drinkRules.*;
import com.kruk.piralcoobot.rules.gameRules.*;
import com.kruk.piralcoobot.rules.roleRules.*;

import static com.kruk.piralcoobot.R.*;

public class Game extends Fragment {

    private static final PlayerType pirateType = new PirateType();
    private static final PlayerType mousseType = new MousseType();
    private static final PlayerType guestType = new GuestType();

    private final int nbRules = 26;

    private int nbMinGulps = 0;
    private int nbMaxGulps = 0;

    private Rule currentRule;
    private ArrayList<Player> players = new ArrayList<Player>();
    private int nbPlayers = 0;
    private ArrayList<Player> pirates = new ArrayList<Player>();
    private int nbPirates = 0;
    private ArrayList<Player> mousses = new ArrayList<Player>();
    private int nbMousses = 0;
    private ArrayList<Player> guests = new ArrayList<Player>();
    private int nbGuests = 0;

    private Rule getRule(int ID) {
        Rule r;
        switch (ID) {
            case 0:
                r = new ClapRule();
                break;
            case 1:
                r = new CulSecRule();
                break;
            case 2:
                r = new DansMonTonneauRule();
                break;
            case 3:
                r = new DistanceMousseRule();
                break;
            case 4:
                r = new MousseVengeanceRule();
                break;
            case 5:
                r = new PartageTonBreuvageRule();
                break;
            case 6:
                r = new PirateTraumatismeRule();
                break;
            case 7:
                r = new PouetRule();
                break;
            case 8:
                r = new ShiFuMiRule();
                break;
            case 9:
                r = new ThemeRule();
                break;
            case 10:
                r = new AuCachotRule();
                break;
            case 11:
                r = new BatailleDeMousseRule();
                break;
            case 12:
                r = new ChoisisLeBonRule();
                break;
            case 13:
                r = new FontaineRule();
                break;
            case 14:
                r = new MutinerieRule();
                break;
            case 15:
                r = new NavireHorizonRule();
                break;
            case 16:
                r = new PasBourreRule();
                break;
            case 17:
                r = new RequinRule();
                break;
            case 18:
                r = new TroisProchainesRule();
                break;
            case 19:
                r = new TuBoisRule();
                break;
            case 20:
                r = new ClassicRule();
                break;
            case 21:
                r = new OnSeFaitAttaquerRule();
                break;
            case 22:
                r = new PagayeRule();
                break;
            case 23:
                r = new DevineLaDirectionRule();
                break;
            case 24:
                r = new OuilleRule();
                break;
            case 25:
                r = new ClownRule();
                break;
            default:
                r = new PartageTonBreuvageRule();
        }
        return r;
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

        view.findViewById(id.button_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Game.this)
                        .navigate(id.action_gameFragment_to_self);
            }
        });

        // Receive gulps /!\ TODO
        nbMinGulps = 3;
        nbMaxGulps = 10;



        // Receive players
        NavDestination context = NavHostFragment.findNavController(Game.this).getGraph().findNode(id.gameFragment);
        String key = "players";
        ArrayList<String> players = ((Bundle) context.getArguments().get(key).getDefaultValue()).getStringArrayList(key);

        for (String player : players) {
            String[] playerPackage = player.split(":");
            String playerName = playerPackage[0];
            String playerTypeName = playerPackage[1];

            Player newPlayer = null;
            if (playerTypeName.equals(pirateType.getName())) {
                newPlayer = new Player(playerName, pirateType);
                this.pirates.add(newPlayer);
                nbPirates++;
            } else if (playerTypeName.equals(mousseType.getName())) {
                newPlayer = new Player(playerName, mousseType);
                this.mousses.add(newPlayer);
                nbMousses++;
            } else if (playerTypeName.equals(guestType.getName())) {
                newPlayer = new Player(playerName, guestType);
                this.guests.add(newPlayer);
                nbGuests++;
            }
            if (newPlayer != null) {
                this.players.add(newPlayer);
                nbPlayers++;
            }
        }

        // Select random rule
        currentRule = getRule(getRandomID(nbRules));
        ConstraintLayout layout = view.findViewById(id.gameLayout);
        Log.d("DEBUG", currentRule.getClass().getName());
        layout.setBackgroundColor(getResources().getColor(currentRule.getRuleColor()));

        TextView ruleTextView = view.findViewById(id.ruleId);

        // Select random players
        ArrayList<Player> selectedPlayers = new ArrayList<>();
        for (int i = 0; i < currentRule.getNbPlayers(); i++) {
            String playerTypeName = currentRule.getPlayerType(i).getName();
            if (playerTypeName.equals(pirateType.getName()))
                selectedPlayers.add(this.pirates.get(getRandomID(nbPirates)));
            else if (playerTypeName.equals(mousseType.getName()))
                selectedPlayers.add(this.mousses.get(getRandomID(nbMousses)));
            else if (playerTypeName.equals(guestType.getName()))
                selectedPlayers.add(this.guests.get(getRandomID(nbGuests)));
            else
                selectedPlayers.add(this.players.get(getRandomID(nbGuests)));
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
}

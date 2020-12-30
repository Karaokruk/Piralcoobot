package com.kruk.piralcoobot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import com.kruk.piralcoobot.rules.AuCachotRule;
import com.kruk.piralcoobot.rules.BatailleDeMousseRule;
import com.kruk.piralcoobot.rules.ChoisisLeBonRule;
import com.kruk.piralcoobot.rules.ClapRule;
import com.kruk.piralcoobot.rules.CulSecRule;
import com.kruk.piralcoobot.rules.DansMonTonneauRule;
import com.kruk.piralcoobot.rules.DistanceMousseRule;
import com.kruk.piralcoobot.rules.FontaineRule;
import com.kruk.piralcoobot.rules.MousseVengeanceRule;
import com.kruk.piralcoobot.rules.MutinerieRule;
import com.kruk.piralcoobot.rules.NavireHorizonRule;
import com.kruk.piralcoobot.rules.PartageTonBreuvageRule;
import com.kruk.piralcoobot.rules.PasBourreRule;
import com.kruk.piralcoobot.rules.PirateTraumatismeRule;
import com.kruk.piralcoobot.rules.PouetRule;
import com.kruk.piralcoobot.rules.RequinRule;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.ShiFuMiRule;
import com.kruk.piralcoobot.rules.ThemeRule;

import java.util.ArrayList;


import com.kruk.piralcoobot.rules.*;
import com.kruk.piralcoobot.rules.deathRules.CulSecRule;
import com.kruk.piralcoobot.rules.deathRules.ShiFuMiRule;
import com.kruk.piralcoobot.rules.drinkRules.DistanceMousseRule;
import com.kruk.piralcoobot.rules.drinkRules.MousseVengeanceRule;
import com.kruk.piralcoobot.rules.drinkRules.PartageTonBreuvageRule;
import com.kruk.piralcoobot.rules.drinkRules.PirateTraumatismeRule;
import com.kruk.piralcoobot.rules.gameRules.ClapRule;
import com.kruk.piralcoobot.rules.gameRules.DansMonTonneauRule;
import com.kruk.piralcoobot.rules.gameRules.PouetRule;
import com.kruk.piralcoobot.rules.gameRules.ThemeRule;

import static com.kruk.piralcoobot.R.*;

public class Game extends Fragment {

    static private int nbRules = 18;

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
            case 0: r = new ClapRule();
                    break;
            case 1: r = new CulSecRule();
                    break;
            case 2: r = new DansMonTonneauRule();
                break;
            case 3: r = new DistanceMousseRule();
                break;
            case 4: r = new MousseVengeanceRule();
                break;
            case 5: r = new PartageTonBreuvageRule();
                break;
            case 6: r = new PirateTraumatismeRule();
                break;
            case 7: r = new PouetRule();
                break;
            case 8: r = new ShiFuMiRule();
                break;
            case 9: r = new ThemeRule();
                break;
            case 10: r = new AuCachotRule();
                break;
            case 11: r = new BatailleDeMousseRule();
                break;
            case 12: r = new ChoisisLeBonRule();
                break;
            case 13: r = new FontaineRule();
                break;
            case 14: r = new MutinerieRule();
                break;
            case 15: r = new NavireHorizonRule();
                break;
            case 16: r = new PasBourreRule();
                break;
            case 17: r = new RequinRule();
                break;
            default:
                r = new PartageTonBreuvageRule();
        }
        return r;
    }

    public static PlayerType getPlayerTypeFromString(String playerName) {
        PlayerType playerType;
        switch (playerName) {
            case ("pirate"):
                playerType = PlayerType.PIRATE;
                break;
            case ("mousse"):
                playerType = PlayerType.MOUSSE;
                break;
            case ("guest"):
                playerType = PlayerType.GUEST;
                break;
            default:
                playerType = PlayerType.GUEST;
        }
        return playerType;
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
        NavDestination context = NavHostFragment.findNavController(Game.this).getGraph().findNode(R.id.gameFragment);
        String key = "players";
        ArrayList<String> players = ((Bundle) context.getArguments().get(key).getDefaultValue()).getStringArrayList(key);

        int separator = 0;
        String tmpName;
        PlayerType tmpType;
        for (String player : players) {
            separator = player.indexOf(":");
            tmpName = player.substring(separator + 1);
            tmpType = getPlayerTypeFromString(player.substring(0, separator));
            if (tmpType == PlayerType.PIRATE) {
                this.pirates.add(new Player(tmpName, tmpType));
                nbPirates++;
            }
            else if (tmpType == PlayerType.MOUSSE) {
                this.mousses.add(new Player(tmpName, tmpType));
                nbMousses++;
            }
            else if (tmpType == PlayerType.GUEST) {
                this.guests.add(new Player(tmpName, tmpType));
                nbGuests++;
            }
            this.players.add(new Player(tmpName, tmpType));
            nbPlayers++;
        }

        // Select random rule
        currentRule = getRule(getRandomID(nbRules));
        ConstraintLayout layout = view.findViewById(id.gameLayout);
        layout.setBackgroundColor(getResources().getColor(currentRule.getRuleColor()));

        TextView ruleTextView = view.findViewById(id.ruleId);
        
                }



        // Select random players
        ArrayList<Player> selectedPlayers = new ArrayList<Player>();
        for (int i = 0 ; i < currentRule.getNbPlayers() ; i++) {
            switch (currentRule.getPlayerType(i)) {
                case PIRATE:
                    selectedPlayers.add(this.pirates.get(getRandomID(nbPirates)));
                    break;
                case MOUSSE:
                    selectedPlayers.add(this.mousses.get(getRandomID(nbMousses)));
                    break;
                case GUEST:
                    selectedPlayers.add(this.guests.get(getRandomID(nbGuests)));
                    break;
                default:
                    selectedPlayers.add(this.players.get(getRandomID(nbPlayers)));
            }
        }

        if (currentRule.hasGulps()) {
            int nbGulps = Math.round((float) Math.random() * (nbMaxGulps - nbMinGulps)) + nbMinGulps;
            switch (currentRule.getNbPlayers()) {
                case 0:
                    ruleTextView.setText(currentRule.getRuleText());
                    break;
                case 1:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).name(), nbGulps));
                    break;
                case 2:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).name(), selectedPlayers.get(1).name(), nbGulps));
                    break;
                default:
                    ruleTextView.setText(currentRule.getRuleText(nbGulps));
            }
        } else {
            switch (currentRule.getNbPlayers()) {
                case 1:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).name()));
                    break;
                case 2:
                    ruleTextView.setText(currentRule.getRuleText(selectedPlayers.get(0).name(), selectedPlayers.get(1).name()));
                    break;
                default:
                    ruleTextView.setText(currentRule.getRuleText());
            }
        }
    }
}

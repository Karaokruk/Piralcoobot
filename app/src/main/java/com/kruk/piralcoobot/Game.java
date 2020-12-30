package com.kruk.piralcoobot;

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

//import java.object;

import static com.kruk.piralcoobot.R.*;

public class Game extends Fragment {

    static private int nbRules = 18;
    private Rule currentRule;

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

        // Receive players
        NavDestination context = NavHostFragment.findNavController(Game.this).getGraph().findNode(R.id.gameFragment);

        String key = "players";
        String playerName = ((Bundle) context.getArguments().get(key).getDefaultValue()).getString(key);
        Log.d("DEBUG", "Player name : " + playerName);

        // Select rule
        int ruleID = (int) (Math.random() * nbRules);
        currentRule = getRule(ruleID);
        ConstraintLayout layout = view.findViewById(id.gameLayout);
        layout.setBackgroundColor(getResources().getColor(currentRule.getRuleColor()));

        TextView ruleTextView = view.findViewById(id.ruleId);
        switch (currentRule.getNbPlayers()){
            case 0:
                if(currentRule.isGlups()) {
                    ruleTextView.setText(currentRule.getRuleText(5));
                }else{
                    ruleTextView.setText(currentRule.getRuleText());
                }
                break;
            case 1:
                if(currentRule.isGlups()){
                    ruleTextView.setText(currentRule.getRuleText(playerName, 3));
                }else{
                    ruleTextView.setText(currentRule.getRuleText(playerName));
                }

                break;
            case 2:
                if(currentRule.isGlups()){
                    ruleTextView.setText(currentRule.getRuleText(playerName, playerName, 4));
                }else{
                    ruleTextView.setText(currentRule.getRuleText(playerName, playerName));
                }

                break;
            default :
                if(currentRule.isGlups()){
                    ruleTextView.setText(currentRule.getRuleText(playerName, 7));
                }else{
                    ruleTextView.setText(currentRule.getRuleText(playerName));
                }


        }

    }
}

package com.kruk.piralcoobot;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.kruk.piralcoobot.rules.ClapRule;
import com.kruk.piralcoobot.rules.CulSecRule;
import com.kruk.piralcoobot.rules.DansMonTonneauRule;
import com.kruk.piralcoobot.rules.DistanceMousseRule;
import com.kruk.piralcoobot.rules.MousseVengeanceRule;
import com.kruk.piralcoobot.rules.PartageTonBreuvageRule;
import com.kruk.piralcoobot.rules.PirateTraumatismeRule;
import com.kruk.piralcoobot.rules.PouetRule;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.ShiFuMiRule;
import com.kruk.piralcoobot.rules.ThemeRule;

import org.w3c.dom.Text;

public class Game extends Fragment {

    static private int nbRules = 1;
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
            default:
                r = new PartageTonBreuvageRule();
        }
        return r;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_page, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Receive players
        //Intent intent = getIntent();
        //String message = intent.getStringExtra("message");

        int ruleID = (int) (Math.random() * nbRules);
        currentRule = getRule(ruleID);
        TextView ruleTextView = view.findViewById(R.id.ruleId);
        ruleTextView.setText(currentRule.getRuleText("Mouss1"));
    }
}

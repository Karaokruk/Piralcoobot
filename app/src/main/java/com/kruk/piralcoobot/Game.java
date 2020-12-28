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

import com.kruk.piralcoobot.rules.CulSecRule;
import com.kruk.piralcoobot.rules.DistanceMousseRule;
import com.kruk.piralcoobot.rules.Rule;

import org.w3c.dom.Text;

public class Game extends Fragment {

    static private int nbRules = 1;
    private Rule currentRule;

    private Rule getRule(int ID) {
        Rule r;
        switch (ID) {
            case 1: r = new CulSecRule();
                    break;
            case 2: r = new DistanceMousseRule();
                    break;
            default:
                r = new DistanceMousseRule();
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

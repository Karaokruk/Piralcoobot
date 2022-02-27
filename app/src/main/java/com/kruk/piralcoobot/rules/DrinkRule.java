package com.kruk.piralcoobot.rules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

import java.util.ArrayList;

public class DrinkRule extends Rule {

    public DrinkRule(RuleType ruleType) {
        super(RuleType.DRINK, R.color.drinkColor);
    }

    public DrinkRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps) {
        super(RuleType.DRINK, R.color.drinkColor, name, ruleText, helpText, nbPlayers, hasGulps);
    }

    public DrinkRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps, ArrayList<PlayerType> playerTypes) {
        super(RuleType.DRINK, R.color.drinkColor, name, ruleText, helpText, nbPlayers, hasGulps, playerTypes);
    }
}

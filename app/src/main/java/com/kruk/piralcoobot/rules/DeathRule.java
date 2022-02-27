package com.kruk.piralcoobot.rules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

import java.util.ArrayList;

public class DeathRule extends Rule {

    public DeathRule() {
        super(RuleType.DEATH, R.color.deathColor);
    }

    public DeathRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps) {
        super(RuleType.DEATH, R.color.deathColor, name, ruleText, helpText, nbPlayers, hasGulps);
    }

    public DeathRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps, ArrayList<PlayerType> playerTypes) {
        super(RuleType.DEATH, R.color.deathColor, name, ruleText, helpText, nbPlayers, hasGulps, playerTypes);
    }
}

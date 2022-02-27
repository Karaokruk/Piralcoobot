package com.kruk.piralcoobot.rules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

import java.util.ArrayList;

public class GameRule extends Rule {

    public GameRule(RuleType ruleType) {
        super(RuleType.GAME, R.color.gameColor);
    }

    public GameRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps) {
        super(RuleType.GAME, R.color.gameColor, name, ruleText, helpText, nbPlayers, hasGulps);
    }

    public GameRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps, ArrayList<PlayerType> playerTypes) {
        super(RuleType.GAME, R.color.gameColor, name, ruleText, helpText, nbPlayers, hasGulps, playerTypes);
    }
}

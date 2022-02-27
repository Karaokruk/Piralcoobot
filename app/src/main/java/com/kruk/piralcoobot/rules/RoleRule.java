package com.kruk.piralcoobot.rules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

import java.util.ArrayList;

public class RoleRule extends Rule {

    public RoleRule() {
        super(RuleType.ROLE, R.color.roleColor);
    }

    public RoleRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps) {
        super(RuleType.ROLE, R.color.roleColor, name, ruleText, helpText, nbPlayers, hasGulps);
    }

    public RoleRule(String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps, ArrayList<PlayerType> playerTypes) {
        super(RuleType.ROLE, R.color.roleColor, name, ruleText, helpText, nbPlayers, hasGulps, playerTypes);
    }
}

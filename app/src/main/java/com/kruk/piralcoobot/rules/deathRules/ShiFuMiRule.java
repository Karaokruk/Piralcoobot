package com.kruk.piralcoobot.rules.deathRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class ShiFuMiRule extends DeathRule {

    public ShiFuMiRule() {
        super(RuleType.DEATH);
        this.name = "shifumi";
        this.ruleText = "<NAME1> & <NAME2>, faites un Shi-fu-mi cul sec.";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.ANY);
        this.playerTypes.add(PlayerType.ANY);
    }

    @Override
    public String getRuleText(String playerName1, String playerName2) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<NAME1>", playerName1);
        rule = rule.replaceAll("<NAME2>", playerName2);
        return rule;
    }
}

package com.kruk.piralcoobot.rules.deathRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class ShiFuMiRule extends DeathRule {

    public ShiFuMiRule() {
        super(RuleType.DEATH);
        this.name = "shifumi";
        this.ruleText = "<NAME1> & <NAME2>, faites un Shi-fu-mi cul sec.";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.hasGulps = false;
        this.playerTypes.add(new PlayerType("", null));
        this.playerTypes.add(new PlayerType("", null));
    }

    @Override
    public String getRuleText(String playerName1, String playerName2) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<NAME1>", playerName1);
        rule = rule.replaceAll("<NAME2>", playerName2);
        return rule;
    }
}

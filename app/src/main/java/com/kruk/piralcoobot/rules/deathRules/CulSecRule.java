package com.kruk.piralcoobot.rules.deathRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class CulSecRule extends DeathRule {

    public CulSecRule() {
        super(RuleType.DEATH);
        this.name = "culSec";
        this.ruleText = "Cul sec pour <NAME> !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(new PlayerType("", null));
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

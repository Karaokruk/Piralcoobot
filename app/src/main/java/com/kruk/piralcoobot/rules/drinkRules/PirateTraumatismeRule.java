package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class PirateTraumatismeRule extends DrinkRule {

    public PirateTraumatismeRule() {
        super(RuleType.DRINK);
        this.name = "PirateTraumatisme ";
        this.ruleText = "<PIRATE>, bois autant de gorgées que de tentatives que tu as passées au Capitaine Paf";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.PIRATE);
    }

    @Override
    public String getRuleText(String playerName1) {
        return this.ruleText.replaceAll("<PIRATE>", playerName1);
    }
}
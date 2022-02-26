package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class TuBoisRule extends DrinkRule {

    public TuBoisRule() {
        super(RuleType.DRINK);
        this.name = "tuBois";
        this.ruleText = "<NAME>, tu bois.";
        this.helpText = "Le joueur boit.";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(new PlayerType("", null));
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

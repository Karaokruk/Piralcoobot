package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class ClassicRule extends DrinkRule {

    public ClassicRule() {
        super(RuleType.DRINK);
        this.name = "classic";
        this.ruleText = "<NAME>, tu bois <GULPS> gorgées.";
        this.helpText = "Le joueur boit le nombre de gorgées indiquées.";
        this.nbPlayers = 1;
        this.hasGulps = true;
        this.playerTypes.add(new PlayerType("", null));
    }

    @Override
    public String getRuleText(String playerName, int nbGulps) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME>", playerName);
        ruleText = ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
        return ruleText;
    }
}

package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class RequinRule extends DrinkRule {

    public RequinRule() {
        super(RuleType.DRINK);
        this.name = "requinRule";
        this.ruleText = "Désignez une personne en même temps, elle boit <GULPS> gorgées.";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }

    @Override
    public String getRuleText(int nbGulps) {
        return this.ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
    }
}
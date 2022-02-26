package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.rules.RuleType;

public class MutinerieRule extends DrinkRule {

    public MutinerieRule() {
        super(RuleType.DRINK);
        this.name = "Mutinerie";
        this.ruleText = "MUTINERIE !! Les matelots se retourne contre le capitaine ! chaque matelot donnent [Nombre de joueurs] gorgées au capitaine et les boivent avec lui !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }

    @Override
    public String getRuleText(int nbGulps) {
        return this.ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
    }
}

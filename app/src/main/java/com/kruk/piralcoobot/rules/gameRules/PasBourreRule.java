package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class PasBourreRule extends GameRule {

    public PasBourreRule() {
        super(RuleType.GAME);
        this.name = "PasBourre";
        this.ruleText = "T'ES PAS BOURRÉ : Laissez la Poule Pirate choisir qui n'a pas encore assez bu, <GULPS> gorgées !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }

    @Override
    public String getRuleText(int nbGulps) {
        return this.ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
    }
}

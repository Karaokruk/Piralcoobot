package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class PasBourreRule extends Rule {

    public PasBourreRule() {
        super(RuleType.GAME);
        this.name = "PasBourre";
        this.ruleText = "T'ES PAS BOURRE  : Laisser la PoulePirate choisir qui n'a pas encore assez bu, <GLUPS> gorgées !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }

    @Override
    public String getRuleText(int nbGlups) {
        return this.ruleText.replaceAll("<GLUPS>", String.valueOf(nbGlups));
    }
}

package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class PagayeRule extends GameRule {

    public PagayeRule() {
        super(RuleType.GAME);
        this.name = "pagaye";
        this.ruleText = "À 3, tout le monde pagaye d'un côté. Ceux qui pagayent du côté le plus choisi boivent <GULPS> gorgées (en cas d'égalité, tout le monde boit).\n 1... 2... 3 !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }


    @Override
    public String getRuleText(int nbGulps) {
        return this.ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
    }
}

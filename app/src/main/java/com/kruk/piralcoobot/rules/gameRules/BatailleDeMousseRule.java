package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class BatailleDeMousseRule extends Rule {


    public BatailleDeMousseRule() {
        super(RuleType.GAME);
        this.name = "BatailleDeMousse";
        this.ruleText = "BATAILLE DE MOUSSES, Les mousses jettent un dé, le mousse qui fait le plus haut score est épargné, les autres boivent N=N+1 gorgées dans l'ordre décroissant de leur score, avec N = <GLUPS>!";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }

    @Override
    public String getRuleText(int nbGlups) {
        return this.ruleText.replaceAll("<GLUPS>", String.valueOf(nbGlups));
    }
}

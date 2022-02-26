package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.rules.RuleType;

public class OnSeFaitAttaquerRule extends GameRule {


    public OnSeFaitAttaquerRule() {
        super(RuleType.GAME);
        this.name = "onSeFaitAttaquer";
        this.ruleText = "ON SE FAIT ATTAQUER ! Nous avons <GULPS> gorgées à essorer, répartissez-vous les gorgées comme vous le souhaitez.";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }

    @Override
    public String getRuleText(int nbGulps) {
        return this.ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps * 4));
    }
}

package com.kruk.piralcoobot.rules;

public class RequinRule extends Rule{

    public RequinRule() {
        super(RuleTypes.DRINK);
        this.name = "RequinRule";
        this.ruleText = "désignez une personne en même temps, il boit <GLUPS> gorgées !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.glups = true;
    }

    @Override
    public String getRuleText(int nbGlups) {
        return this.ruleText.replaceAll("<GLUPS>", String.valueOf(nbGlups));
    }
}
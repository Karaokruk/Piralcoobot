package com.kruk.piralcoobot.rules;

public class PirateTraumatismeRule extends Rule{

    public PirateTraumatismeRule() {
        super(ruleTypes.DRINK);
        this.name = "PirateTraumatisme ";
        this.ruleText = "<PIRATE> bois autant de gorgées que de tentatives que tu as passées au Capitaine Paf";
        this.helpText = "blblbl";
    }

    @Override
    public String getRuleText(String playerName1, int nbGlups) {
        return this.ruleText.replaceAll("<PIRATE>", playerName1);
    }
}
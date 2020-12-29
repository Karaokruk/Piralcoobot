package com.kruk.piralcoobot.rules;

public class PirateTraumatismeRule extends Rule{

    public PirateTraumatismeRule() {
        super(RuleTypes.DRINK);
        this.name = "PirateTraumatisme ";
        this.ruleText = "<PIRATE> bois autant de gorgées que de tentatives que tu as passées au Capitaine Paf";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.glups = false;
    }

    @Override
    public String getRuleText(String playerName1) {
        return this.ruleText.replaceAll("<PIRATE>", playerName1);
    }
}
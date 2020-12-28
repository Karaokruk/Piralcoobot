package com.kruk.piralcoobot.rules;

public class ClapRule extends Rule{

    public ClapRule() {
        this.name = "Clap ";
        this.ruleText = "Clap, <NAME> commence. \n <GULPS> gorgées pour le perdant !";
        this.helpText = "blblbl";
        this.ruleType = ruleTypes.GAME;
    }

    @Override
    public String getRuleText(String playerName, int nbGlups) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<NAME>", playerName);
        rule = rule.replaceAll("<GLUPS>", String.valueOf(nbGlups));

        return rule;
    }
}

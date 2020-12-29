package com.kruk.piralcoobot.rules;

public class ClapRule extends Rule{

    public ClapRule() {
        super(RuleTypes.GAME);
        this.name = "Clap ";
        this.ruleText = "Clap, <NAME> commence. \n <GLUPS> gorgées pour le perdant !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.glups = true;
    }

    @Override
    public String getRuleText(String playerName, int nbGlups) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<NAME>", playerName);
        rule = rule.replaceAll("<GLUPS>", String.valueOf(nbGlups));

        return rule;
    }
}

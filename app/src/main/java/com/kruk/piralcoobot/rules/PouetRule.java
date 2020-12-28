package com.kruk.piralcoobot.rules;

public class PouetRule extends Rule{

    public PouetRule() {
        this.name = "Pouet ";
        this.ruleText = "Pouet, <NAME> commence. \n  <GLUPS> gorgées pour le perdant !";
        this.helpText = "blblbl";
        this.ruleType = ruleTypes.GAME;
    }

    @Override
    public String getRuleText(String playerName, int nbGlups) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<NAME>", playerName);
        rule = rule.replaceAll("<GLUPS", String.valueOf(nbGlups));

        return rule;
    }
}

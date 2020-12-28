package com.kruk.piralcoobot.rules;

public class DansMonTonneauRule extends Rule {

    public DansMonTonneauRule() {
        this.name = "DansMonTonneau ";
        this.ruleText = "Dans mon tonneau, <NAME> commence. \n Le perdant bois le nombre d'objets dans mon tonneau !";
        this.helpText = "blblbl";
        this.ruleType = ruleTypes.GAME;
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

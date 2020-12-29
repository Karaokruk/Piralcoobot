package com.kruk.piralcoobot.rules;

public class DansMonTonneauRule extends Rule {

    public DansMonTonneauRule() {
        super(ruleTypes.GAME);
        this.name = "DansMonTonneau ";
        this.ruleText = "Dans mon tonneau, <NAME> commence. \n Le perdant bois le nombre d'objets dans mon tonneau !";
        this.helpText = "blblbl";
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

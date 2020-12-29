package com.kruk.piralcoobot.rules;

public class DansMonTonneauRule extends Rule {

    public DansMonTonneauRule() {
        super(RuleTypes.GAME);
        this.name = "DansMonTonneau ";
        this.ruleText = "Dans mon tonneau, <NAME> commence. \n Le perdant bois le nombre d'objets dans mon tonneau !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.glups = false;
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

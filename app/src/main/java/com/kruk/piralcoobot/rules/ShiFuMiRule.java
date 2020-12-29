package com.kruk.piralcoobot.rules;

public class ShiFuMiRule extends Rule{

    public ShiFuMiRule() {
        super(ruleTypes.MINIGAME);
        this.name = "ShiFuMi ";
        this.ruleText = "<NAME1> <NAME2> faites un Shi-fu-mi. \n  <GLUPS> gorgées pour le perdant !";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.glups = true;
    }

    @Override
    public String getRuleText(String playerName1, String playerName2, int nbGlups) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<NAME1>", playerName1);
        rule = rule.replaceAll("<NAME2>", playerName2);
        rule = rule.replaceAll("<GLUPS>", String.valueOf(nbGlups));
        return rule;
    }
}

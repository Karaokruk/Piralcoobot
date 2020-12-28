package com.kruk.piralcoobot.rules;

public class ThemeRule extends Rule{

    public ThemeRule() {
        this.name = "Theme";
        this.ruleText = "Jeux des thèmes, <NAME> choisis un thème. \n Le perdant bois le nombre de réponse au thème !";
        this.helpText = "blblbl";
        this.ruleType = ruleTypes.GAME;
    }

    @Override
    public String getRuleText(String playerName, int nbGlups) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

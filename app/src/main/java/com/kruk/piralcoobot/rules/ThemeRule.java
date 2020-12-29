package com.kruk.piralcoobot.rules;

public class ThemeRule extends Rule{

    public ThemeRule() {
        super(RuleTypes.GAME);
        this.name = "Theme";
        this.ruleText = "Jeux des thèmes, <NAME> choisis un thème. \n Le perdant bois le nombre de réponse au thème !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.glups = false;
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

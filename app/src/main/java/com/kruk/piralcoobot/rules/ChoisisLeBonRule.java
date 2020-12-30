package com.kruk.piralcoobot.rules;

public class ChoisisLeBonRule extends Rule{

    public ChoisisLeBonRule() {
        super(RuleTypes.MINIGAME);
        this.name = "ChoisisLeBon";
        this.ruleText = " Choisis le bon ! <PIRATE1> et <PIRATE2> choisisse leur mousse respectif et mise des gorgés. Les mousses choisissent une carte face caché puis la retourne ensemble la plus grande gagne.";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.glups = false;
    }

    @Override
    public String getRuleText(String playerName1, String playerName2) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<PIRATE1>", playerName1);
        rule = rule.replaceAll("<PIRATE2>", playerName2);
        return rule;
    }
}

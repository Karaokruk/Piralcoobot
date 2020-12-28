package com.kruk.piralcoobot.rules;

public class PartageTonBreuvageRule extends Rule{

    public PartageTonBreuvageRule() {
        this.name = "PartageTonBreuvage";
        this.ruleText = "<NAME1> verse un peu de la boisson la plus proche dans le verre de <NAME2> (les verres comptent comme une boisson)!";
        this.helpText = "blblbl";
        this.ruleType = ruleTypes.GAME;
    }

    @Override
    public String getRuleText(String playerName1, String playerName2) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<NAME1>", playerName1);
        rule = rule.replaceAll("<NAME2", playerName2);

        return rule;
    }
}

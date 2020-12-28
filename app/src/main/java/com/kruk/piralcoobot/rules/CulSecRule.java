package com.kruk.piralcoobot.rules;

public class CulSecRule extends Rule {

    public CulSecRule() {
        this.name = "culSec";
        this.ruleText = "Cul sec pour <NAME> !";
        this.helpText = "blblbl";
        this.ruleType = ruleTypes.DRINK;
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

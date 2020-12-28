package com.kruk.piralcoobot.rules;

public class MousseVengeanceRule extends Rule{

    public MousseVengeanceRule() {
        this.name = "MousseVengeance ";
        this.ruleText = "<MOUSSE> finis le verre de <PIRATE> puis remplis le avec ce que tu veux !";
        this.helpText = "blblbl";
        this.ruleType = ruleTypes.DRINK;
    }

    @Override
    public String getRuleText(String mousseName, String pirateName) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<MOUSSE>", mousseName);
        rule = rule.replaceAll( "<PIRATE>", pirateName);

        return rule;
    }
}

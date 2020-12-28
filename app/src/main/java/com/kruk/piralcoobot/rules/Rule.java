package com.kruk.piralcoobot.rules;


public abstract class Rule {
    public String name;
    public String ruleText;
    public String helpText;
    public ruleTypes ruleType;

    public String getRuleText() {
        return "";
    }

    public String getRuleText(String playerName) {
        return "";
    }

    public String getRuleText(String playerName, int nbGlups) {
        return "";
    }

    public String getRuleText(String playerName1, String playerName2) { return ""; }

    public String getRuleText(String playerName1, String playerName2, int nbGlups) { return ""; }

}

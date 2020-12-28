package com.kruk.piralcoobot.rules;


public abstract class Rule {
    public String name;
    public String ruleText;
    public String helpText;
    public ruleTypes ruleType;

    public String getRuleText() {
        return "";
    }

    public String getRuleText(String PlayerName) {
        return "";
    }

    public String getRuleText(String PlayerName1, String PlayerName2) {
        return "";
    }
}

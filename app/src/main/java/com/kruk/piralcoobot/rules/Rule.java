package com.kruk.piralcoobot.rules;
import com.kruk.piralcoobot.R;


public abstract class Rule {
    protected String name;
    protected String ruleText;
    protected String helpText;
    protected ruleTypes ruleType;
    protected int color;

    public Rule (ruleTypes ruleType){

        this.ruleType = ruleType;

        switch(ruleType) {
            case DRINK:
                this.color = R.color.drinkColor;
                break;
            case MINIGAME:
                this.color = R.color.miniGameColor;
                break;
            case GAME:
                this.color = R.color.gameColor;
                break;
            case ROLE:
                this.color = R.color.roleColor;
                break;
            default :
                this.color = R.color.defaultColor;
    }
}

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

    public int getRuleColor(){ return this.color; }

}

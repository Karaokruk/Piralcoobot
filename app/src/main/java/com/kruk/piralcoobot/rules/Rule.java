package com.kruk.piralcoobot.rules;

import com.kruk.piralcoobot.playerType.PlayerType;

import java.util.ArrayList;


public abstract class Rule {
    protected String name;
    protected String ruleText;
    protected String helpText;
    protected RuleType ruleType;
    protected int nbPlayers;
    protected Boolean hasGulps;
    protected int color;
    protected ArrayList<PlayerType> playerTypes;

    public Rule(RuleType ruleType) {
        this.playerTypes = new ArrayList<PlayerType>();
        this.ruleType = ruleType;
    }

    public static String getRandomDirection() {
        return (Math.round((float) Math.random()) == 0) ? "droite" : "gauche";
    }


    public String getRuleText() { return ""; }

    public String getRuleText(int nbGulps) { return ""; }

    public String getRuleText(String playerName) { return ""; }

    public String getRuleText(String playerName, int nbGulps) { return ""; }

    public String getRuleText(String playerName1, String playerName2) { return ""; }

    public String getRuleText(String playerName1, String playerName2, int nbGulps) { return ""; }

    public int getRuleColor() { return this.color; }

    public int getNbPlayers() { return this.nbPlayers; }

    public Boolean hasGulps() { return this.hasGulps; }

    public PlayerType getPlayerType(int id) { return this.playerTypes.get(id); }
}

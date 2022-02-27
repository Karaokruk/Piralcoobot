package com.kruk.piralcoobot.rules;

import com.kruk.piralcoobot.playerType.PlayerType;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.ColorRes;


public abstract class Rule implements Serializable {
    protected String name;
    protected String ruleText;
    protected String helpText;
    protected RuleType ruleType;
    protected int nbPlayers;
    protected Boolean hasGulps;
    protected ArrayList<PlayerType> playerTypes;
    @ColorRes
    protected int colorId;

    public Rule(RuleType ruleType, int colorId) {
        this.playerTypes = new ArrayList<PlayerType>();
        this.ruleType = ruleType;
        this.colorId = colorId;
    }

    public Rule(RuleType ruleType, int colorId, String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps) {
        this.ruleType = ruleType;
        this.colorId = colorId;
        this.name = name;
        this.ruleText = ruleText;
        this.helpText = helpText;
        this.nbPlayers = nbPlayers;
        this.hasGulps = hasGulps;
    }

    public Rule(RuleType ruleType, int colorId, String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps, ArrayList<PlayerType> playerTypes) {
        this.ruleType = ruleType;
        this.colorId = colorId;
        this.name = name;
        this.ruleText = ruleText;
        this.helpText = helpText;
        this.nbPlayers = nbPlayers;
        this.hasGulps = hasGulps;
        this.playerTypes = playerTypes;
    }

    public static String getRandomDirection() {
        return (Math.round((float) Math.random()) == 0) ? "gauche" : "droite";
    }

    public String getRuleText() {
        return this.ruleText.replaceAll("<DIRECTION>", getRandomDirection());
    }

    public String getRuleText(int nbGulps) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        return ruleText;
    }

    public String getRuleText(String playerName) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME>", playerName);
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        return ruleText;
    }

    public String getRuleText(String playerName, int nbGulps) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME>", playerName);
        ruleText = ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        return ruleText;
    }

    public String getRuleText(String playerName1, String playerName2) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME1>", playerName1);
        ruleText = ruleText.replaceAll("<NAME2>", playerName2);
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        return ruleText;
    }

    public String getRuleText(String playerName1, String playerName2, int nbGulps) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME1>", playerName1);
        ruleText = ruleText.replaceAll("<NAME2>", playerName2);
        ruleText = ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        return ruleText;
    }

    public int getRuleColorId() { return this.colorId; }

    public int getNbPlayers() { return this.nbPlayers; }

    public Boolean hasGulps() { return this.hasGulps; }

    public PlayerType getPlayerType(int id) { return this.playerTypes.get(id); }
}

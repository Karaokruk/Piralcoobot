package com.kruk.piralcoobot.rules;

import com.google.gson.annotations.SerializedName;
import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.playerType.PlayerType;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.ColorRes;


public class Rule implements Serializable {
    @SerializedName("name")
    protected String name;
    @SerializedName("rule_text")
    protected String ruleText;
    @SerializedName("help_text")
    protected String helpText;
    @SerializedName("rule_type")
    protected String ruleType;
    @SerializedName("nb_players")
    protected int nbPlayers;
    @SerializedName("has_gulps")
    protected Boolean hasGulps;
    @SerializedName("player_types")
    protected ArrayList<String> playerTypes = new ArrayList<>();


    protected ArrayList<PlayerType> playerTypesClass;
    protected RuleType ruleTypeClass;
    @ColorRes
    protected int colorId;

    public Rule(RuleType ruleTypeClass, int colorId) {
        this.playerTypesClass = new ArrayList<PlayerType>();
        this.ruleTypeClass = ruleTypeClass;
        this.colorId = colorId;
    }

    public Rule(RuleType ruleTypeClass, int colorId, String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps) {
        this.ruleTypeClass = ruleTypeClass;
        this.colorId = colorId;
        this.name = name;
        this.ruleText = ruleText;
        this.helpText = helpText;
        this.nbPlayers = nbPlayers;
        this.hasGulps = hasGulps;
    }

    public Rule(RuleType ruleTypeClass, int colorId, String name, String ruleText, String helpText, int nbPlayers, Boolean hasGulps, ArrayList<PlayerType> playerTypesClass) {
        this.ruleTypeClass = ruleTypeClass;
        this.colorId = colorId;
        this.name = name;
        this.ruleText = ruleText;
        this.helpText = helpText;
        this.nbPlayers = nbPlayers;
        this.hasGulps = hasGulps;
        this.playerTypesClass = playerTypesClass;
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

    public int getRuleColorId() {
        switch (ruleType)
        {
            case "death":
                return R.color.deathColor;
            case "drink":
                return R.color.drinkColor;
            case "game":
                return R.color.gameColor;
            case "role":
                return R.color.roleColor;
            default:
                return R.color.appBackground;
        }
    }

    public int getNbPlayers() { return this.nbPlayers; }

    public Boolean hasGulps() { return this.hasGulps; }

    public PlayerType getPlayerType(int id) {
        switch (playerTypes.get(id))
        {
            case "pirate":
                return PlayerType.PIRATE;
            case "mousse":
                return PlayerType.MOUSSE;
            case "guest":
                return PlayerType.GUEST;
            default:
                return PlayerType.ANY;
        }
    }
}

package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class PartageTonBreuvageRule extends DrinkRule {

    public PartageTonBreuvageRule() {
        super(RuleType.GAME);
        this.name = "PartageTonBreuvage";
        this.ruleText = "<NAME1>, verse un peu de la boisson la plus proche dans le verre de <NAME2> (les verres comptent comme une boisson).";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.ANY);
        this.playerTypes.add(PlayerType.ANY);
    }

    @Override
    public String getRuleText(String playerName1, String playerName2) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME1>", playerName1);
        ruleText = ruleText.replaceAll("<NAME2>", playerName2);
        return ruleText;
    }
}

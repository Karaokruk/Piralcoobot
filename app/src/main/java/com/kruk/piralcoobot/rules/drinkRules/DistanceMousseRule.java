package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class DistanceMousseRule extends DrinkRule {

    public DistanceMousseRule() {
        super(RuleType.DRINK);
        this.name = "distanceMousse";
        this.ruleText = "<NAME>, tu bois autant de gorgées qu'il y a de personnes entre toi et le premier mousse à ta <DIRECTION>.";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(new PlayerType("", null));
    }

    @Override
    public String getRuleText(String playerName) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME>", playerName);
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        return ruleText;
    }
}

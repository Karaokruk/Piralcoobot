package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class ThemeRule extends GameRule {

    public ThemeRule() {
        super(RuleType.GAME);
        this.name = "theme";
        this.ruleText = "Thème, <NAME> commence, sens vers la <DIRECTION>.\n Le perdant boit en gorgées le nombre de réponses au thème.";
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

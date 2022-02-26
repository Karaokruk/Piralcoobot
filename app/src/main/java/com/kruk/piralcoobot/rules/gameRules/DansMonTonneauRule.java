package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class DansMonTonneauRule extends GameRule {

    public DansMonTonneauRule() {
        super(RuleType.GAME);
        this.name = "dansMonTonneau ";
        this.ruleText = "Dans mon tonneau, <NAME> commence, sens vers la <DIRECTION>. \n Le perdant boit le nombre d'objets dans mon tonneau.";
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

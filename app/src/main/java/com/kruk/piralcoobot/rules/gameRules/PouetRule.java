package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class PouetRule extends GameRule {

    public PouetRule() {
        super(RuleType.GAME);
        this.name = "Pouet ";
        this.ruleText = "Pouet, <NAME> commence, sens vers la <DIRECTION>.\n <GULPS> gorgées pour le perdant.";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.hasGulps = true;
        this.playerTypes.add(new PlayerType("", null));
    }

    @Override
    public String getRuleText(String playerName, int nbGulps) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<NAME>", playerName);
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        ruleText = ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
        return ruleText;
    }
}

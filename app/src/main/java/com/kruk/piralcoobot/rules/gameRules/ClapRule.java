package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class ClapRule extends GameRule {

    public ClapRule() {
        super(RuleType.GAME);
        this.name = "clap";
        this.ruleText = "Clap, <NAME> commence, sens vers la <DIRECTION>.\n <GULPS> gorgées pour le perdant.";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.hasGulps = true;
        this.playerTypes.add(PlayerType.ANY);
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

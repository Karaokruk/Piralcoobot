package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class OuilleRule extends GameRule {

    public OuilleRule() {
        super(RuleType.GAME);
        this.name = "ouille ";
        this.ruleText = "Chacun son tour, une rime en -ouille ! <NAME> commence, sens vers la <DIRECTION>. PRÊÊÊÊTS ?!\nC'est moiiiiii le plus grand pirate de l'îîîîîîîîle !\nJe trucide et j'écrabouille, et je m'en mets plein les -";
        this.helpText = "blblbl ;)";
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

package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class MousseVengeanceRule extends DrinkRule {

    public MousseVengeanceRule() {
        super(RuleType.DRINK);
        this.name = "MousseVengeance ";
        this.ruleText = "<MOUSSE>, finis le verre de <PIRATE> puis remplis-le avec ce que tu veux (le verre, pas le pirate).";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.MOUSSE);
        this.playerTypes.add(PlayerType.PIRATE);
    }

    @Override
    public String getRuleText(String mousseName, String pirateName) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<MOUSSE>", mousseName);
        rule = rule.replaceAll( "<PIRATE>", pirateName);

        return rule;
    }
}

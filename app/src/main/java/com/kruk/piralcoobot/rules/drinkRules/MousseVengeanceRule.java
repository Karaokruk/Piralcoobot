package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.playerType.MousseType;
import com.kruk.piralcoobot.playerType.PirateType;
import com.kruk.piralcoobot.rules.RuleType;

public class MousseVengeanceRule extends DrinkRule {

    public MousseVengeanceRule() {
        super(RuleType.DRINK);
        this.name = "MousseVengeance ";
        this.ruleText = "<MOUSSE>, finis le verre de <PIRATE> puis remplis-le avec ce que tu veux (le verre, pas le pirate).";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.hasGulps = false;
        this.playerTypes.add(new MousseType());
        this.playerTypes.add(new PirateType());
    }

    @Override
    public String getRuleText(String mousseName, String pirateName) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<MOUSSE>", mousseName);
        rule = rule.replaceAll("<PIRATE>", pirateName);

        return rule;
    }
}

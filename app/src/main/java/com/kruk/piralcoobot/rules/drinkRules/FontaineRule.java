package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class FontaineRule extends DrinkRule {

    public FontaineRule(){

        super(RuleType.DRINK);
        this.name = "Fontaine";
        this.ruleText = "Fontaine : <NAME> tu commences, sens vers la <DIRECTION> !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.ANY);
    }

    @Override
    public String getRuleText(String namePlayer) {
        String rule =this.ruleText;
        rule = rule.replaceAll("<DIRECTION>", getRandomDirection());
        rule = rule.replaceAll("<NAME>", namePlayer);

        return rule;
    }

}

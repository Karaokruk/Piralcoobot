package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class TroisProchainesRule extends DrinkRule {

    public TroisProchainesRule() {
        super(RuleType.DRINK);
        this.name = "troisProchaines";
        this.ruleText = "<NAME>, pour étancher ta soif, accompagne les victimes des trois prochaines règles.";
        this.helpText = "Pour les trois règles qui suivent celle-ci, le joueur ciblé va boire autant de gorgées que tous les joueurs qui en sont victimes.";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.ANY);
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

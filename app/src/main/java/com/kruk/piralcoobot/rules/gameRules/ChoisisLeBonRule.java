package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class ChoisisLeBonRule extends Rule {

    public ChoisisLeBonRule() {
        super(RuleType.GAME);
        this.name = "ChoisisLeBon";
        this.ruleText = "Choisis le bon ! <PIRATE1> et <PIRATE2> choisissent leur mousse respectif et misent des gorgées dessus. Les mousses choisissent une carte face cachée puis la retourne ensemble. La plus grande gagne (mais l'as perd).";
        this.helpText = "blblbl";
        this.nbPlayers = 2;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.PIRATE);
    }

    @Override
    public String getRuleText(String playerName1, String playerName2) {
        String rule = this.ruleText;
        rule = rule.replaceAll("<PIRATE1>", playerName1);
        rule = rule.replaceAll("<PIRATE2>", playerName2);
        return rule;
    }
}

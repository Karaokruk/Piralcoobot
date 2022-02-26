package com.kruk.piralcoobot.rules.roleRules;

import com.kruk.piralcoobot.playerType.PlayerType;
import com.kruk.piralcoobot.rules.RuleType;

public class ClownRule extends RoleRule {

    public ClownRule() {
        super(RuleType.ROLE);
        this.name = "clown";
        this.ruleText = "<NAME>, à partir de maintenant, si tu fais rire quelqu'un, la victime prend un cul sec.";
        this.helpText = "MOI J'SUIS UN CLOWN ?.";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(new PlayerType("", null));
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

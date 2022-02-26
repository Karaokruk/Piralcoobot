package com.kruk.piralcoobot.rules.deathRules;

import com.kruk.piralcoobot.rules.RuleType;

public class NavireHorizonRule extends DeathRule {

    public NavireHorizonRule() {
        super(RuleType.DRINK);
        this.name = "NavireHorizon";
        this.ruleText = "Navire à l'horizon : finissez vos verres moussaillons, à l'abordage !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.hasGulps = false;
    }

    @Override
    public String getRuleText() {
        return this.ruleText;
    }

}

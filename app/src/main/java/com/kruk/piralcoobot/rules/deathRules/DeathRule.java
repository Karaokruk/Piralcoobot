package com.kruk.piralcoobot.rules.deathRules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public abstract class DeathRule extends Rule {

    public DeathRule(RuleType ruleType) {
        super(ruleType);
        this.color = R.color.deathColor;
    }
}

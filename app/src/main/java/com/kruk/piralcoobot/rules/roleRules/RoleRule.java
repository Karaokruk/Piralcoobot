package com.kruk.piralcoobot.rules.roleRules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public abstract class RoleRule extends Rule {

    public RoleRule(RuleType ruleType) {
        super(ruleType);
        this.color = R.color.deathColor;
    }
}

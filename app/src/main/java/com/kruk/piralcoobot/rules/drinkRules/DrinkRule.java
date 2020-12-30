package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public abstract class DrinkRule extends Rule {

    public DrinkRule(RuleType ruleType) {
        super(ruleType);
        this.color = R.color.drinkColor;
    }
}

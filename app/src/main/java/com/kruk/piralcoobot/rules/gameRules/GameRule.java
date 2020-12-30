package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.R;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public abstract class GameRule extends Rule {

    public GameRule(RuleType ruleType) {
        super(ruleType);
        this.color = R.color.gameColor;
    }
}

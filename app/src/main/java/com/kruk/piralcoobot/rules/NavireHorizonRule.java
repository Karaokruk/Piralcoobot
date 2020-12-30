package com.kruk.piralcoobot.rules;

public class NavireHorizonRule extends Rule{

    public NavireHorizonRule() {
        super(RuleTypes.DRINK);
        this.name = "NavireHorizon";
        this.ruleText = "Navire à l'horizon : finissez vos verres moussaillons, à l'abordage !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.glups = false;
    }

    @Override
    public String getRuleText() {
        return this.ruleText;
    }

}

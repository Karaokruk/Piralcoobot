package com.kruk.piralcoobot.rules;

public class MutinerieRule extends Rule {

    public MutinerieRule() {
        super(RuleTypes.DRINK);
        this.name = "Mutinerie";
        this.ruleText = " MUTINERIE !! Les matelots se retourne contre le capitaine ! chaque matelot donnent [Nombre de joueurs] gorgées au capitaine et les boivent avec lui !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.glups = true;
    }

    @Override
    public String getRuleText(int nbGlups) {
        return this.ruleText.replaceAll("<GLUPS>", String.valueOf(nbGlups));
    }
}

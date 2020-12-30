package com.kruk.piralcoobot.rules;

public class PasBourreRule extends Rule{

    public PasBourreRule() {
        super(RuleTypes.MINIGAME);
        this.name = "PasBourre";
        this.ruleText = "T'ES PAS BOURRE  : Laisser la PoulePirate choisir qui n'a pas encore assez bu, <GLUPS> gorgées !";
        this.helpText = "blblbl";
        this.nbPlayers = 0;
        this.glups = true;
    }

    @Override
    public String getRuleText(int nbGlups) {
        return this.ruleText.replaceAll("<GLUPS>", String.valueOf(nbGlups));
    }
}

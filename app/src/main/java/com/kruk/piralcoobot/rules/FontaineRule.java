package com.kruk.piralcoobot.rules;

public class FontaineRule extends Rule{

    public FontaineRule(){

        super(RuleTypes.DRINK);
        this.name = "Fontaine";
        this.ruleText = "Fontaine : <NAME> tu commences, on tourne à gauche !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.glups = false;
    }

    @Override
    public String getRuleText(String namePlayer) {
        return this.ruleText.replaceAll("<NAME>", namePlayer);
    }

}

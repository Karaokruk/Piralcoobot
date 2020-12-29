package com.kruk.piralcoobot.rules;

public class DistanceMousseRule extends Rule{

    public DistanceMousseRule(){
        super(ruleTypes.DRINK);
        this.name = "dsitanceMousse";
        this.ruleText = "<NAME>, tu bois autant de gorgées qu'il y a de personnes entre toi et le premier mousse à ta droite !\n Si tu es un mousse bois 5.";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.glups = false;
    }

    @Override
    public String getRuleText(String playerName) {
        return this.ruleText.replaceAll("<NAME>", playerName);
    }
}

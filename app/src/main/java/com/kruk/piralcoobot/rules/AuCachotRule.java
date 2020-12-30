package com.kruk.piralcoobot.rules;

public class AuCachotRule extends Rule{

    public AuCachotRule(){
        super(RuleTypes.DRINK);
        this.name = "AuCachot";
        this.ruleText = "AU CACHOT : <NAME> rentre au cachot, privé d'alcool ( esquive la prochaine buvance) !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.glups = false;
    }

    @Override
    public String getRuleText(String namePlayer) {
        return this.ruleText.replaceAll("<NAME>", namePlayer);
    }


}

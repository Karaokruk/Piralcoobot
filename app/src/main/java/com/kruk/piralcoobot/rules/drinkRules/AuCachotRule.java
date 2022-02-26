package com.kruk.piralcoobot.rules.drinkRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class AuCachotRule extends DrinkRule {

    public AuCachotRule(){
        super(RuleType.DRINK);
        this.name = "AuCachot";
        this.ruleText = "AU CACHOT : <NAME> rentre au cachot, privé d'alcool (esquive la prochaine buvance) !";
        this.helpText = "blblbl";
        this.nbPlayers = 1;
        this.hasGulps = false;
        this.playerTypes.add(PlayerType.ANY);
    }

    @Override
    public String getRuleText(String namePlayer) {
        return this.ruleText.replaceAll("<NAME>", namePlayer);
    }


}

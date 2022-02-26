package com.kruk.piralcoobot.rules.gameRules;

import com.kruk.piralcoobot.PlayerType;
import com.kruk.piralcoobot.rules.Rule;
import com.kruk.piralcoobot.rules.RuleType;

public class DevineLaDirectionRule extends GameRule {

    public DevineLaDirectionRule() {
        super(RuleType.GAME);
        this.name = "devineLaDirection";
        this.ruleText = "DEVINE LA DIRECTION !\n Tout le monde se tourne vers un de ses voisins. Si c'est le bon voisin, il boit, sinon, c'est l'autre qui boit. <GULPS> gorgées sont en jeu. Et le bon voisin était... Celui à votre <DIRECTION> !";
        this.helpText = "Le lecteur de la règle ne joue pas.";
        this.nbPlayers = 0;
        this.hasGulps = true;
    }

    @Override
    public String getRuleText(int nbGulps) {
        String ruleText = this.ruleText;
        ruleText = ruleText.replaceAll("<GULPS>", String.valueOf(nbGulps));
        ruleText = ruleText.replaceAll("<DIRECTION>", getRandomDirection());
        return ruleText;
    }
}

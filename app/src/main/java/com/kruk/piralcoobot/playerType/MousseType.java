package com.kruk.piralcoobot.playerType;

import com.kruk.piralcoobot.R;

public class MousseType extends PlayerType {

    public MousseType() {
        super("Mousse", new PlayerTypeLayoutInformation(
                R.string.mousse,
                R.string.mousseList,
                R.color.moussePrimary,
                R.color.mousseSecondary
        ));
    }
}

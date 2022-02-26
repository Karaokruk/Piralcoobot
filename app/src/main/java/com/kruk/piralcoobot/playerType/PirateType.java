package com.kruk.piralcoobot.playerType;

import com.kruk.piralcoobot.R;

public class PirateType extends PlayerType {

    public PirateType() {
        super("Pirate", new PlayerTypeLayoutInformation(
                R.string.pirate,
                R.string.pirateList,
                R.color.piratePrimary,
                R.color.pirateSecondary
        ));
    }
}

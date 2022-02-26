package com.kruk.piralcoobot.playerType;

import com.kruk.piralcoobot.R;

public class GuestType extends PlayerType {

    public GuestType() {
        super("Guest", new PlayerTypeLayoutInformation(
                R.string.guest,
                R.string.guestList,
                R.color.guestPrimary,
                R.color.guestSecondary
        ));
    }
}

package com.kruk.piralcoobot.playerType;

import java.io.Serializable;

public class PlayerType implements Serializable {
    private final String name;
    private final PlayerTypeLayoutInformation layoutInformation;

    public PlayerType(String name, PlayerTypeLayoutInformation layoutInformation) {
        this.name = name;
        this.layoutInformation = layoutInformation;
    }

    public String getName() {
        return this.name;
    }

    public PlayerTypeLayoutInformation getLayoutInformation() {
        return this.layoutInformation;
    }
}

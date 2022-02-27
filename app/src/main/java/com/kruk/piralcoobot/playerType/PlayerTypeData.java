package com.kruk.piralcoobot.playerType;

import java.io.Serializable;

public class PlayerTypeData implements Serializable {
    private final PlayerType playerType;
    private final String name;
    private final PlayerTypeLayoutInformation layoutInformation;

    public PlayerTypeData(PlayerType playerType, String name, PlayerTypeLayoutInformation layoutInformation) {
        this.playerType = playerType;
        this.name = name;
        this.layoutInformation = layoutInformation;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

    public String getName() {
        return this.name;
    }

    public PlayerTypeLayoutInformation getLayoutInformation() {
        return this.layoutInformation;
    }
}

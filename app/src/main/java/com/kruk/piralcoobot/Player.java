package com.kruk.piralcoobot;

import com.kruk.piralcoobot.playerType.PlayerType;

public class Player {
    private final String name;
    private final PlayerType playerType;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    public String getName() {
        return this.name;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }
}

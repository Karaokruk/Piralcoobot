package com.kruk.piralcoobot;

public class Player {
    private String name;
    private PlayerType playerType;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    public String name() {
        return this.name;
    }

    public PlayerType playerType() {
        return this.playerType;
    }
}

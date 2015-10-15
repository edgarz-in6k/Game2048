package com.game;

public class GameCell {

    private int value;

    GameCell(){
        this(0);
    }

    public GameCell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

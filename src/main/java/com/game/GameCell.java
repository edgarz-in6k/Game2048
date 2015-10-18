package com.game;

public class GameCell {

    private long value;

    GameCell(){
        this(0);
    }

    public GameCell(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

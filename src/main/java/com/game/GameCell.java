package com.game;

import java.util.ArrayList;

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
        ArrayList a;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public boolean equals(GameCell gameCell){
        return this.getValue() == gameCell.getValue();
    }
}
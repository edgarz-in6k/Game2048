package com.game;

import java.util.ArrayList;
import java.util.List;

public class GameField {
    private List<ArrayList<GameCell>> cells = new ArrayList<>();
    private int size;

    public GameField(int size) {
        this.size = size;
        createCells(size);
        //fillTwoCellsRandom();
    }

    private void createCells(int size) {
        for (int row=0; row<size; row++){
            cells.add(new ArrayList<>());
            for (int coll = 0; coll < size; coll++) {
                cells.get(row).add(new GameCell());
            }
        }
    }

    //public int[] testCreateCells(int)
}

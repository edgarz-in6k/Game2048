package com.game;

import java.util.ArrayList;
import java.util.List;

public class StaticCellValueGenerator implements CellValueGenerator{

    private List<ArrayList<GameCell>> cells;
    private int size;

    @Override
    public void fillEntryCell() {
        /*Random random = new Random();
        int randomRow = random.nextInt(size);
        int randomColl = random.nextInt(size);
        while (cells.get(randomRow).get(randomColl).getValue() != 0) {
            randomRow = random.nextInt(size);
            randomColl = random.nextInt(size);
        }
        cells.get(randomRow).set(randomColl, new GameCell(5));*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells.get(i).get(j).getValue() == 0){//getValue(i, j)
                    cells.get(i).set(j, new GameCell(2)); //setValue(i, j, 2);
                    return;
                }
            }
        }
    }

    @Override
    public void setCells(List<ArrayList<GameCell>> cells) {
        this.cells = cells;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
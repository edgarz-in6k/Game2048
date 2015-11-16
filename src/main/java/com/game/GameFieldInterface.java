package com.game;

import com.filler.CellValueFiller;

public interface GameFieldInterface {
    boolean move(Direction direction);
    void fillEmptyCell();
    boolean hasAvailableMoves();
    boolean hasCellWith2048();
    long getScore();
    GameCell getCell(int row, int col);
    int getSize();
    CellValueFiller getFiller();
    long[] getArray();
}
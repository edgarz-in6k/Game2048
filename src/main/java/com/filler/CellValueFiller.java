package com.filler;

import com.game.GameCell;

import java.util.List;

public interface CellValueFiller {
    void fillEntryCell(List<GameCell> emptyCell);

    void setSize(int size);
}
package com.generator;

import com.game.GameCell;

import java.util.ArrayList;
import java.util.List;

public interface CellValueGenerator {
    void getNumber();

    void setCells(List<ArrayList<GameCell>> cells);

    void setSize(int size);
}

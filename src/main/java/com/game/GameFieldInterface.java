package com.game;

public interface GameFieldInterface {
    boolean move(Direction direction);
    void fillEmptyCell();
    boolean hasAvailableMoves();
    boolean hasCellWith2048();
    long getScore();
    GameCell getCell(int row, int col);
}
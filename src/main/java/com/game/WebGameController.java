package com.game;

public class WebGameController extends GameControllerAbstract {
    @Override
    void beginGame() {
        field.fillEmptyCell();
        field.fillEmptyCell();
    }

    @Override
    boolean makeStep() {
        return false;
    }
}

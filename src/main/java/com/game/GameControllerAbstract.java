package com.game;

public abstract class GameControllerAbstract {
    protected GameFieldInterface field;
    abstract void beginGame();
    abstract void makeStep(Direction direction);
}

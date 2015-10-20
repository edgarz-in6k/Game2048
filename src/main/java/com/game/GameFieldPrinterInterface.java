package com.game;

public interface GameFieldPrinterInterface {
    void printToStream(GameFieldInterface field);
    void printToStream(String s);
    void indent();
}
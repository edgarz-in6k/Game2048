package com.generator;

public class StaticCellValueGenerator implements CellValueGenerator{

    private long value;

    public StaticCellValueGenerator() {
        value = 2;
    }

    public StaticCellValueGenerator(long value) {
        this.value = value;
    }

    @Override
    public long getNumber() {
        return value;
    }
}
package com.generator;

public class StaticProgressiveCellValueGenerator implements CellValueGenerator{

    private long startValue;
    private static long value;

    public StaticProgressiveCellValueGenerator() {
        startValue = 2;
        value = startValue;
    }

    public StaticProgressiveCellValueGenerator(long start){
        startValue = start;
        value = startValue;
    }

    public void refresh(){
        value = startValue;
    }

    @Override
    public long getNumber() {
        value *= 2;
        return value/2;
    }
}
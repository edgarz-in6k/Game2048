package com.generator;

public class RandomCellValueGenerator implements CellValueGenerator{
    @Override
    public long getNumber() {
        return twoOrFour();
    }

    private long twoOrFour() {
        return (Math.random()<0.9 ? 2 : 4);//new Random().nextInt(2)*2+2
    }
}
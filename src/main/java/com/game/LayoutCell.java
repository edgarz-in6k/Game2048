package com.game;

public enum LayoutCell {
    NULL(0, "\u001B[97m"),
    TWO(2, "\u001B[1m"),
    FOUR(4, "\u001B[2m"),
    EIGHT(8, "\u001B[30m"),
    SIXTEEN(16, "\u001B[35m"),
    TWENTY_TWO(32, "\u001B[36m"),
    SIXTY_FOUR(64, "\u001B[34m"),
    ONE_HUNDRED_TWENTY_EIGHT(128, "\u001B[32m"),
    TWO_HUNDRED_AND_FIFTY_SIX(256, "\u001B[33m"),
    FIVE_HUNDRED_AND_TWELVE(512, "\u001B[93m"),
    ONE_THOUSAND_AND_TWENTY_FOUR(1024, "\u001B[91m"),
    TWO_THOUSAND_AND_FORTY_EIGHT(2048, "\u001B[31m");

    public final long value;
    public final String color;
    public static final String RESET_COLOR = "\u001B[0m";

    LayoutCell(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public static String valueToColor(long k){
        for (LayoutCell lc : LayoutCell.values()){
            if (lc.value == k)
                return lc.color;
        }
        System.err.println("ERROR: valueToColor");
        return "";
    }
}
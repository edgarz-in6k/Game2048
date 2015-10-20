package com.game;

public enum LayoutCell {
    NULL(0, "\u001B[47m"),
    TWO(2, "\u001B[40m"),
    FOUR(4, "\u001B[100m"),
    EIGHT(8, "\u001B[104m"),
    SIXTEEN(16, "\u001B[44m"),
    TWENTY_TWO(32, "\u001B[106m"),
    SIXTY_FOUR(64, "\u001B[46m"),
    ONE_HUNDRED_TWENTY_EIGHT(128, "\u001B[43m"),
    TWO_HUNDRED_AND_FIFTY_SIX(256, "\u001B[103m"),
    FIVE_HUNDRED_AND_TWELVE(512, "\u001B[105m"),
    ONE_THOUSAND_AND_TWENTY_FOUR(1024, "\u001B[101m"),
    TWO_THOUSAND_AND_FORTY_EIGHT(2048, "\u001B[41m");

    public final long value;
    public final String color;
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String OTHER = "\u001B[42m";//41
    public static final String COLOR_SCORE = "\u001B[107m";

    LayoutCell(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public static String valueToColor(long k){
        for (LayoutCell lc : LayoutCell.values()){
            if (lc.value == k)
                return lc.color;
        }
        return OTHER;
    }
}

/*
NULL(0, "\u001B[97m"),
    TWO(2, "\u001B[30m"),
    FOUR(4, "\u001B[35m"),
    EIGHT(8, "\u001B[95m"),
    SIXTEEN(16, "\u001B[36m"),
    TWENTY_TWO(32, "\u001B[34m"),
    SIXTY_FOUR(64, "\u001B[32m"),
    ONE_HUNDRED_TWENTY_EIGHT(128, "\u001B[33m"),
    TWO_HUNDRED_AND_FIFTY_SIX(256, "\u001B[92m"),
    FIVE_HUNDRED_AND_TWELVE(512, "\u001B[93m"),
    ONE_THOUSAND_AND_TWENTY_FOUR(1024, "\u001B[91m"),
    TWO_THOUSAND_AND_FORTY_EIGHT(2048, "\u001B[31m");
*/
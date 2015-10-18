package com.game;

public enum ValueCell {
    TWO(2),
    FOUR(4),
    EIGHT(8),
    SIXTEEN(16),
    TWENTY_TWO(32),
    SIXTY_FOUR(64),
    ONE_HUNDRED_TWENTY_EIGHT(128),
    TWO_HUNDRED_AND_FIFTY_SIX(256),
    PYATSOT_TWELVE(512),
    ONE_THOUSAND_AND_TWENTY_FOUR(1024),
    TWO_THOUSAND_AND_FORTY_EIGHT(2048);

    public final long value;

    ValueCell(int value) {
        this.value = value;
    }
}

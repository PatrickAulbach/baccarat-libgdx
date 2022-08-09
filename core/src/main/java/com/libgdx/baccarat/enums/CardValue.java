package com.libgdx.baccarat.enums;

import lombok.Getter;

public enum CardValue {
    ACE(1),
    DEUCE(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    OTHER(0);

    @Getter
    private final int value;

    CardValue(int value) {
        this.value = value;
    }
}

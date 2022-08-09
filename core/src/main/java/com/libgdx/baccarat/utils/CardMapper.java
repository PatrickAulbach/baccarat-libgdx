package com.libgdx.baccarat.utils;


import com.libgdx.baccarat.enums.CardValue;

public class CardMapper {

    public static CardValue getValue(String cardName) {
        return switch (cardName) {
            case "card-clubs-1", "card-diamonds-1", "card-hearts-1", "card-spades-1" -> CardValue.ACE;
            case "card-clubs-2", "card-diamonds-2", "card-hearts-2", "card-spades-2" -> CardValue.DEUCE;
            case "card-clubs-3", "card-diamonds-3", "card-hearts-3", "card-spades-3" -> CardValue.THREE;
            case "card-clubs-4", "card-diamonds-4", "card-hearts-4", "card-spades-4" -> CardValue.FOUR;
            case "card-clubs-5", "card-diamonds-5", "card-hearts-5", "card-spades-5" -> CardValue.FIVE;
            case "card-clubs-6", "card-diamonds-6", "card-hearts-6", "card-spades-6" -> CardValue.SIX;
            case "card-clubs-7", "card-diamonds-7", "card-hearts-7", "card-spades-7" -> CardValue.SEVEN;
            case "card-clubs-8", "card-diamonds-8", "card-hearts-8", "card-spades-8" -> CardValue.EIGHT;
            case "card-clubs-9", "card-diamonds-9", "card-hearts-9", "card-spades-9" -> CardValue.NINE;
            default -> CardValue.OTHER;
        };
    }
}

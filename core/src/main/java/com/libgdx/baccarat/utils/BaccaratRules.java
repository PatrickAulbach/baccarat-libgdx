package com.libgdx.baccarat.utils;

public class BaccaratRules {

    public boolean checkEntityDraw(int score) {
        return score <= 5;
    }

    public boolean isNatural(int playerScore, int bankerScore) {
        return playerScore == 8 || playerScore == 9 || bankerScore == 8 || bankerScore == 9;
    }

    public boolean checkBankerDraw(int bankerScore, int playersThirdCard) {

        return switch (bankerScore) {
            case 0, 1, 2 -> true;
            case 3 -> playersThirdCard != 8;
            case 4 -> playersThirdCard >= 2 && playersThirdCard <= 7;
            case 5 -> playersThirdCard >= 4 && playersThirdCard <= 7;
            case 6 -> playersThirdCard >= 6 && playersThirdCard <= 7;
            default -> false;
        };
    }
}

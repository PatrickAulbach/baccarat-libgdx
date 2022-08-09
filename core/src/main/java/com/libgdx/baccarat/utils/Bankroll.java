package com.libgdx.baccarat.utils;

import lombok.Getter;

public class Bankroll {

    @Getter
    private int bankroll;

    public Bankroll(int bankroll) {
        this.bankroll = bankroll;
    }

    public boolean bet(int amount) {
        if (this.bankroll - amount < 0) {
            return false;
        }

        this.bankroll -= amount;
        return true;
    }

    public void add(int amount) {
        this.bankroll += amount;
    }
}

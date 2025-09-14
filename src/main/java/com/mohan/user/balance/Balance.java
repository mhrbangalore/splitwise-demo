package com.mohan.user.balance;

import com.mohan.user.User;

public class Balance {

    private double amountOwe;
    private double amountGetBack;
    private double effectiveBalance;

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public double getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(double amountGetBack) {
        this.amountGetBack = amountGetBack;
    }

    public double getEffectiveBalance() {
        return this.effectiveBalance;
    }

    public void setEffectiveBalance() {
        this.effectiveBalance = this.amountGetBack - this.amountOwe;
    }
}

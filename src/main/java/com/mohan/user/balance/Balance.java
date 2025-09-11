package com.mohan.user.balance;

import com.mohan.user.User;

public class Balance {

    private User amountOwedBy;
    private double amountOwed;

    public Balance(User amountOwedBy, double amountOwed) {
        this.amountOwedBy = amountOwedBy;
        this.amountOwed = amountOwed;
    }

    public User getAmountOwedBy() {
        return amountOwedBy;
    }

    public void setAmountOwedBy(User amountOwedBy) {
        this.amountOwedBy = amountOwedBy;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }
}

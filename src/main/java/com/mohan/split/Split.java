package com.mohan.split;

import com.mohan.user.User;

public class Split {

    private User user;
    private double amountOwe;

    public Split(User user, double amountOwe) {
        this.user = user;
        this.amountOwe = amountOwe;
    }

    public User getUser() {
        return user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }
}

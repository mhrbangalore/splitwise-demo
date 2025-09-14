package com.mohan.user.balance;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {

    private Map<String, Balance> userVsBalance;
    private double totalPayments;
    private double totalExpenses;
    private double amountYouOwe;
    private double amountGetBack;

    public UserExpenseBalanceSheet() {
        this.userVsBalance = new HashMap<>();
        totalPayments = 0.0;
        totalExpenses = 0.0;
        amountGetBack = 0.0;
        amountYouOwe = 0.0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getAmountYouOwe() {
        return amountYouOwe;
    }

    public void setAmountYouOwe(double amountYouOwe) {
        this.amountYouOwe = amountYouOwe;
    }

    public double getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(double amountGetBack) {
        this.amountGetBack = amountGetBack;
    }

}

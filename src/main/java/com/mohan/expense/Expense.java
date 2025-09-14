package com.mohan.expense;

import com.mohan.split.Split;
import com.mohan.user.User;

import java.util.List;

public class Expense {

    private final String expenseId;
    private String description;
    private double expenseAmount;
    private User paidByUser;
    private ExpenseSplitType expenseSplitType;
    private List<Split> splits;

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser,
                   ExpenseSplitType expenseSplitType, List<Split> splits) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.expenseSplitType = expenseSplitType;
        this.splits = splits;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public User getPaidByUser() {
        return paidByUser;
    }

    public ExpenseSplitType getExpenseSplitType() {
        return expenseSplitType;
    }

    public List<Split> getSplits() {
        return splits;
    }
}

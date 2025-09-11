package com.mohan.controllers;

import com.mohan.expense.Expense;
import com.mohan.expense.ExpenseSplitType;
import com.mohan.split.Split;
import com.mohan.split.splitStrategy.EqualSplitStrategy;
import com.mohan.split.splitStrategy.ISplitStrategy;
import com.mohan.split.splitStrategy.PercentageSplitStrategy;
import com.mohan.split.splitStrategy.UnEqualSplitStrategy;
import com.mohan.user.User;

import java.util.List;

public class ExpenseController {

    private BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, User paidByUser,
                                 ExpenseSplitType expenseSplitType, List<Split> splits){
        ISplitStrategy splitStrategy = switch (expenseSplitType){
            case EQUAL -> new EqualSplitStrategy();
            case UNEQUAL -> new UnEqualSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
            default -> throw new IllegalArgumentException("Not a valid split type");
        };
        splitStrategy.validateSplitRequest(splits, expenseAmount);
        this.balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, expenseAmount, splits);
        Expense expense = new Expense(expenseId, description, expenseAmount,
                paidByUser, expenseSplitType, splits);
        return expense;
    }
}

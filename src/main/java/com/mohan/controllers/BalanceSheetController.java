package com.mohan.controllers;

import com.mohan.expense.Expense;
import com.mohan.group.Group;
import com.mohan.split.Split;
import com.mohan.user.User;
import com.mohan.user.balance.Balance;
import com.mohan.user.balance.UserExpenseBalanceSheet;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateUserExpenseBalanceSheet(User paidByUser, double expenseAmount, List<Split> splits) {

        UserExpenseBalanceSheet payerBalanceSheet = paidByUser.getUserExpenseBalanceSheet();
        payerBalanceSheet.setTotalPayments(payerBalanceSheet.getTotalPayments() + expenseAmount);

        for (Split split : splits){
            double amountOwe = split.getAmountOwe();
            User payee = split.getUser();
            if (payee.getUserId().equals(paidByUser.getUserId())){
                payerBalanceSheet.setTotalExpenses(payerBalanceSheet.getTotalExpenses() + amountOwe);
            } else {
                UserExpenseBalanceSheet payeeBalanceSheet = payee.getUserExpenseBalanceSheet();
                Balance payerBalance = payerBalanceSheet.getUserVsBalance()
                        .computeIfAbsent(payee.getUserId(), k -> new Balance());
                payerBalance.setAmountGetBack(payerBalance.getAmountGetBack() + amountOwe);
                payerBalanceSheet.setAmountGetBack(payerBalanceSheet.getAmountGetBack() + amountOwe);
                payerBalance.setEffectiveBalance();

                payeeBalanceSheet.setTotalExpenses(payerBalanceSheet.getTotalExpenses() + amountOwe);
                payeeBalanceSheet.setAmountYouOwe(payeeBalanceSheet.getAmountYouOwe() + amountOwe);
                Balance payeeBalance = payeeBalanceSheet.getUserVsBalance()
                        .computeIfAbsent(paidByUser.getUserId(), k -> new Balance());
                payeeBalance.setAmountOwe(payeeBalance.getAmountOwe() + amountOwe);
                payeeBalance.setEffectiveBalance();
            }
        }

    }

    public void showBalanceSheetOfAUser(User user){
        System.out.println("==================================================");

        System.out.println("Expense Balance sheet of user id: " + user.getUserId());
        System.out.println("Total Payments: " + user.getUserExpenseBalanceSheet().getTotalPayments());
        System.out.println("Total Expenses: " + user.getUserExpenseBalanceSheet().getTotalExpenses());
        System.out.println("Total Amount Get Back: " + user.getUserExpenseBalanceSheet().getAmountGetBack());
        System.out.println("Total Amount You Owe: " + user.getUserExpenseBalanceSheet().getAmountYouOwe());

        for (Map.Entry<String, Balance> entry : user.getUserExpenseBalanceSheet().getUserVsBalance().entrySet()){
            System.out.println("Expenses with user id: " + entry.getKey() + "; Amount You Get Back: " + entry.getValue().getAmountGetBack()
            + "; Amount You Owe: " + entry.getValue().getAmountOwe() + effectiveBalanceMessage(entry.getValue().getEffectiveBalance()));
        }

        System.out.println("==================================================");
    }

    public void showExpensesByGroup(String groupId, GroupController groupController){
        Group group = groupController.getGroupById(groupId);
        if (group == null){
            System.out.println("There is no such group with this id: " + groupId);
        } else {
            System.out.println("==================================================");
            System.out.println("Expenses of group: " + groupId);
            System.out.println("==================================================");
            for (Expense expense : group.getGroupExpenses()){
                User paiByUser = expense.getPaidByUser();
                System.out.println("Expense Description: " + expense.getDescription());
                System.out.println("Total Expense amount: " + expense.getExpenseAmount());
                System.out.println("Paid By: " + paiByUser.getUserId());
                for (Split split : expense.getSplits()){
                    if (split.getUser() != paiByUser) {
                        System.out.println(split.getUser().getUserId() + " Owes " + paiByUser.getUserId() + ": " +split.getAmountOwe());
                    }
                }
                System.out.println("==================================================");
            }
        }
    }

    private String effectiveBalanceMessage(double effectiveBalance){
        return effectiveBalance >= 0 ? "; Owes You: " + effectiveBalance : "; You Owe: " + effectiveBalance * -1;
    }























}

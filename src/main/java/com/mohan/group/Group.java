package com.mohan.group;

import com.mohan.controllers.ExpenseController;
import com.mohan.expense.Expense;
import com.mohan.user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupId;
    private String groupName;
    private List<User> groupMembers;
    private List<Expense> groupExpenses;
    private ExpenseController expenseController;

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupMembers = new ArrayList<>();
        this.groupExpenses = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }

    public void addUserToGroup(User user){
        if (groupMembers.contains(user)){
            System.out.println("User with id -> " + user.getUserId() +
                    " and name " + user.getUserName() + " is already present in the group");
        } else {
            System.out.println("User with id -> " + user.getUserId() +
                    " and name " + user.getUserName() + " is added to the group successfully");
            groupMembers.add(user);
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }
}

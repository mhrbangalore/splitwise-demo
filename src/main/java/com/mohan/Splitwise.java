package com.mohan;

import com.mohan.controllers.BalanceSheetController;
import com.mohan.controllers.ExpenseController;
import com.mohan.controllers.GroupController;
import com.mohan.controllers.UserController;
import com.mohan.expense.ExpenseSplitType;
import com.mohan.group.Group;
import com.mohan.split.Split;
import com.mohan.user.User;

import java.util.List;

public class Splitwise {

    private static Splitwise instance;
    private UserController userController;
    private GroupController groupController;
    private ExpenseController expenseController;
    private BalanceSheetController balanceSheetController;

    private Splitwise(){
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.expenseController = new ExpenseController();
        this.balanceSheetController = new BalanceSheetController();
    }

    public static Splitwise getInstance(){
        if (instance == null){
            synchronized (Splitwise.class){
                if (instance == null){
                    instance = new Splitwise();
                }
            }
        }
        return instance;
    }

    public void execute(){
        setUpUsersAndGroups();
        Group group = groupController.getGroupById("G001");
        User user1 = userController.getUserById("U001");
        User user2 = userController.getUserById("U002");
        User user3 = userController.getUserById("U003");
        group.createExpense(
                "EXP001",
                "Breakfast",
                600,
                user1,
                ExpenseSplitType.EQUAL,
                List.of(new Split(user2, 200),
                        new Split(user3, 200),
                        new Split(user1, 200))
        );

        group.createExpense(
                "EXP002",
                "Dinner",
                1200,
                user2,
                ExpenseSplitType.EQUAL,
                List.of(new Split(user2, 400),
                        new Split(user3, 400),
                        new Split(user1, 400))
        );

        for (User user : userController.getAllUsers()){
            balanceSheetController.showBalanceSheetOfAUser(user);
        }

    }

    private void setUpUsersAndGroups(){
        createUsers();
        this.groupController.createGroup("G001", "Outing with friends");
        Group group = groupController.getGroupById("G001");
        group.addUserToGroup(userController.getUserById("U001"));
        group.addUserToGroup(userController.getUserById("U002"));
        group.addUserToGroup(userController.getUserById("U003"));
    }

    private void createUsers(){
        User user1 = new User("U001", "Amy");
        User user2 = new User("U002", "Bob");
        User user3 = new User("U003", "Charlie");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }

























}

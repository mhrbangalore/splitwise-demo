package com.mohan.controllers;

import com.mohan.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
    }

    public User addUser(User user){
        if (userList.contains(user)){
            System.out.println("User is already present");
            return null;
        }
        userList.add(user);
        return user;
    }

    public User getUserById(String id){
        for (User user : userList){
            if (user.getUserId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return this.userList;
    }
}

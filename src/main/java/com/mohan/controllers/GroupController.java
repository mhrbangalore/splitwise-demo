package com.mohan.controllers;

import com.mohan.group.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    private List<Group> groups;

    public GroupController() {
        this.groups = new ArrayList<>();
    }

    public Group createGroup(String groupId, String groupName){
        Group group = new Group(groupId, groupName);
        if (groups.contains(group)){
            System.out.println("Group is already present..");
        } else {
            System.out.println("Group is created successfully");
            groups.add(group);
            return group;
        }
        return null;
    }

    public Group getGroupById(String id){
        for (Group group : groups){
            if (group.getGroupId().equals(id)){
                return group;
            } else {
                System.out.println("There is no group with id: " + id);
            }
        }
        return null;
    }


    public List<Group> getGroups() {
        return groups;
    }
}

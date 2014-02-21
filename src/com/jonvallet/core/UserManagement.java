package com.jonvallet.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserManagement {

    Map<String, User> userDatabaseNoSql = new HashMap<>();


    public UserManagement(){

    }

    public UserManagement(Map<String, User> users) {
        userDatabaseNoSql = users;
    }


    public void addUser(String nick) {

        User user = new User(nick);
        if (userDatabaseNoSql.containsKey(nick)){
            throw new RuntimeException("User id: "+nick+" already registered.");
        }else{

            userDatabaseNoSql.put(nick, user);
        }
    }

    public void addFollower(String nick, String follower) {
        userDatabaseNoSql.get(nick).getFollowers().add(follower);
    }

    public Set<String> getFollowerList(String nick) {


        return userDatabaseNoSql.get(nick).getFollowers();
    }

    public Map<String, User> getUsers() {
        return userDatabaseNoSql;
    }
}

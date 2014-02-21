package com.jonvallet.core;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
    
    private String nick;
    private Set<String> followers = new HashSet<>();

    public User(String nick) {

         setNick(nick);
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof User){
            return nick.equals(((User) obj).getNick());
        }

        return false;
    }



    @Override
    public int hashCode() {
        return nick.hashCode();
    }
}

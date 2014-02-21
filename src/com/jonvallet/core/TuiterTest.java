package com.jonvallet.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class TuiterTest {

    @Test
    public void addUserRafaNotAndNoExceptionIsThrown(){
        UserManagement tuiter = new UserManagement();
        tuiter.addUser("Rafa");
    }

    @Test
    public void addUsersTaniaAndRafaIsAlreadyRegisteredNoExceptionIsThrown(){
        UserManagement tuiter = new UserManagement();
        tuiter.addUser("Rafa");
        tuiter.addUser("Tania");
    }

    @Test(expected = Exception.class)
    public void ifUserIsRegisterThrownError() {
        UserManagement tuiter = new UserManagement();
        tuiter.addUser("Rafa");
        tuiter.addUser("Rafa");

    }
    @Test
    public void whenGettingRafaFollowersAndTaniaIsFollowingHimTaniaIsReturned(){
        UserManagement tuiter = new UserManagement();

        tuiter.addUser("Rafa");
        tuiter.addFollower("Rafa", "Tania");
        Assert.assertTrue(tuiter.getFollowerList("Rafa").contains("Tania"));
    }


    @Test(expected = Exception.class)
    public void whenLoadingDatabaseWithUserRafaWhenAddingUserRafaAnExceptionIsThrown(){

        UserManagement userManagement = new UserManagement();
        userManagement.addUser("Rafa");

        new PersistenceFile().save(userManagement.getUsers());

        Map<String, User> users = new PersistenceFile().load();

        UserManagement tuiter = new UserManagement(users);


        tuiter.addUser("Rafa");

    }


}

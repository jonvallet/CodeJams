package com.jonvallet.tuits;

import com.jonvallet.core.UserManagement;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created with IntelliJ IDEA.
 * User: jvalletw
 * Date: 5/12/13
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class TuitsTest {

    private Map<String,List<String>> roars = new HashMap<>();

    @Test
    public void getTheRoarListFromUserRafaAndRafaHasNoneTuit(){
        List<String> expected = new ArrayList<>();
        List<String> actualValue = getTuits("Rafa");
        Assert.assertEquals(expected.size(), actualValue.size());
    }


    @Test
    public void getTheRoarListFromUserRafaWithRoarsAndIsNotEmpty(){


        publishRoar("Rafa", "HOLA!!");
        List<String> actualValue = getTuits("Rafa");
        Assert.assertTrue(actualValue.size() > 0);

    }

    private void publishRoar(String nick, String message) {

        getTuits(nick).add(message);
    }

    private List<String> getTuits(String nick) {
        return roars.get(nick);
    }

}

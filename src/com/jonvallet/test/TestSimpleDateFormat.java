package com.jonvallet.test;

import junit.framework.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by jvalletw on 12/12/13.
 */
public class TestSimpleDateFormat {



    @Test
    public void TestADateIsCreatedWithFormatddmmyyyy(){

        Date date = new GregorianCalendar(2012,0,1).getTime();
        String expectedDate = "01/01/2012";

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(expectedDate, df.format(date));

    }
}

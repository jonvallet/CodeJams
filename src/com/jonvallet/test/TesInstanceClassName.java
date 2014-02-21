package com.jonvallet.test;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by jvalletw on 12/12/13.
 */
public class TesInstanceClassName {

    @Test
    public void testWhenInstancingAStringClassClassNameIsString() throws ClassNotFoundException {

        Class<String> className = (Class<String>) Class.forName("java.lang.String");

        String expected = String.class.getName();
        String actual = className.getName();

        Assert.assertEquals(expected,actual);


    }
}

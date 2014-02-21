package com.jonvallet.codejam;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jvalletw
 * Date: 22/10/13
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzz {


    public static final String FIZZ = "FIZZ";
    public static final String BUZZ = "BUZZ";



    public static void main (String [] args ){

        FizzBuzz fizzBuzz = new FizzBuzz();


        for (int i = 1; i < 100; i++){

            System.out.print(fizzBuzz.getFizzBuzz(i)+" ");

        }

    }


    @Test
    public void testWhen3ThenFizzIsReturned(){
        String expected = FIZZ;
        String actual = getFizzBuzz(3);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testWhen5ThenBuzzIsReturned(){
        String expected = BUZZ;
        String actual = getFizzBuzz(5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWhen15ThenFIZZBUZZIsReturned(){

        String expected = FIZZ+BUZZ;
        String actual = getFizzBuzz(15);

        Assert.assertEquals(expected, actual);

    }

    private String getFizzBuzz(int i) {

        if (i % 15 == 0){
            return FIZZ+BUZZ;
        }

        if (i % 3 == 0){
            return FIZZ;
        }

        if (i % 5 == 0){
            return BUZZ;
        }

        return String.valueOf(i);  //To change body of created methods use File | Settings | File Templates.
    }



}

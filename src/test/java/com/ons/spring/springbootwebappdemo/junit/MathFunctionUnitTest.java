package com.ons.spring.springbootwebappdemo.junit;

import com.ons.spring.springbootwebappdemo.MathFunctions;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by tobinj on 10/06/2018.
 */
public class MathFunctionUnitTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }

    @Test
    public void test() {
        System.out.println("Test 1");
        //fail("Not yet implemented!");
    }

    @Test
    public void sum_with_3_numbers(){
        System.out.println("Test 2");
        MathFunctions mathFunctions = new MathFunctions();
        int result = mathFunctions.sum(new int[]{1,2,3});
        System.out.println("Sum = " + result);
        // check the result is correct
        assertEquals(6, result);

    }

    @After
    public void after(){
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
}

package com.ons.spring.springbootwebappdemo;

/**
 * Created by tobinj on 10/06/2018.
 */
public class MathFunctions {

    public int sum(int[] numbers){
        int sum = 0;
        for (int i : numbers){
            sum+= i;

        }
        return sum;
    }

}

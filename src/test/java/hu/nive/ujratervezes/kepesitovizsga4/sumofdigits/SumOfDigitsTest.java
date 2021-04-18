package hu.nive.ujratervezes.kepesitovizsga4.sumofdigits;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SumOfDigitsTest {

    @Test
    public void getSumOfDigits() {
        Assertions.assertEquals(9, new SumOfDigits().getSumOfDigits(new Random(1)));
    }
    @Test
    public void getSumOfDigitsRecursive() {
        Assertions.assertEquals(9, new SumOfDigits().getSumOfDigitsRecursive(new Random(1)));
    }
}
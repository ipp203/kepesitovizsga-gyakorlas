package hu.nive.ujratervezes.kepesitovizsga1.numberofdigits;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfDigitsTest {

    @Test
    void testGetNumberOfDigits() {
        Assertions.assertEquals(13, new NumberOfDigits().getNumberOfDigits(11));
    }

    @Test
    void testGetNumberOfDigitsWithZero() {
        Assertions.assertEquals(0, new NumberOfDigits().getNumberOfDigits(0));
    }
}


package hu.nive.ujratervezes.kepesitovizsga1.numberofdigits;

import java.util.stream.IntStream;

public class NumberOfDigits {

    public int getNumberOfDigits(int number){
//        int result = 0;
//        for (int i = 1; i <= number; i++) {
//            result+=(""+i).length();
//        }
//        return result;

//        StringBuilder result = new StringBuilder();
//        for (int i = 1; i <= number; i++) {
//            result.append(i);
//        }
//        return result.length();

        IntStream stream = IntStream.rangeClosed(1,number);
        return stream.mapToObj(String::valueOf)
                .mapToInt(String::length)
                .sum();

    }
}

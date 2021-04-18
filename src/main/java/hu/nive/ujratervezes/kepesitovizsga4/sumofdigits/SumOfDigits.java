package hu.nive.ujratervezes.kepesitovizsga4.sumofdigits;

import java.util.Random;

public class SumOfDigits {

    public int getSumOfDigits(Random rnd) {
        int number = Math.abs(rnd.nextInt());

        do {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        } while (number > 10);

        return number;
    }

    public int getSumOfDigitsRecursive(Random rnd) {
        return sumOfDigits(Math.abs(rnd.nextInt()));
    }

    private int sumOfDigits(int number){
        if(number<10){
            return number;
        }
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sumOfDigits(sum);
    }
}

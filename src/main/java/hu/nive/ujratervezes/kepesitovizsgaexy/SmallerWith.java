package hu.nive.ujratervezes.kepesitovizsgaexy;

import java.util.Arrays;

public class SmallerWith {

    public int smallerWith(int limit, int[] numbers) {
        validateParameters(limit, numbers);

        int max = getMax(numbers);

        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int n : numbers) {
            int value = max - limit - n;
            if (value < min && value >= 0) {
                min = value;
                result = n;
            }
        }

        if (result == -1) {
            throw new IllegalStateException("There is no such number!");
        }
        return result;
    }

    private void validateParameters(int limit, int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Every parameter is a must!");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("Value is out of range!");
        }
    }

    private int getMax(int[] numbers) {
        int max = 0;
        for (int n : numbers) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public int smallerWith(int... numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Every parameter is a must!");
        }
        return smallerWith(numbers[0], Arrays.copyOfRange(numbers, 1, numbers.length));
    }
}

package hu.nive.ujratervezes.kepesitovizsgaexy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fibonacci {

    private static final Long[] valuesOfFibonacci = new Long[101];

    public long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n parameter must be greater, than 0");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (valuesOfFibonacci[n] == null) {
            valuesOfFibonacci[n] = fib(n - 2) + fib(n - 1);
        }
        return valuesOfFibonacci[n];
    }

    public String getPrims(int numbersOfFibonacci) {
        if (numbersOfFibonacci < 0) {
            throw new IllegalArgumentException("Invalid parameter!");
        }
        List<Long> result = new ArrayList<>();

        for (int i = 1; i <= numbersOfFibonacci; i++) {
            long f = fib(i);

            if (isPrim(f)) {
                result.add(f);
            }
        }
        return result.stream()
                .distinct()
                .map(l -> Long.toString(l))
                .collect(Collectors.joining(", "));
    }

    public List<Integer> getPiecesPrims(int numbersOfPrimFibonacci) {

        List<Integer> result = new ArrayList<>();
        int n = 1;

        while (result.size() < numbersOfPrimFibonacci) {
            long f = fib(n);
            if (isPrim(f)) {
                result.add((int) f);
            }
            n++;
        }
        return result;
    }

    private boolean isPrim(long numb) {
        if (numb == 1) {
            return true;
        }
        int limit = (int) Math.sqrt((double) numb);
        for (int i = 2; i <= limit; i++) {
            if (numb % i == 0) {
                return false;
            }
        }
        return true;
    }
}

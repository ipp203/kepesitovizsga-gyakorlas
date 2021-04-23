package hu.nive.ujratervezes.kepesitovizsga5.cinderella;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cinderella {
    private final int[] numbers = new int[5];
    private final String[] words = {"Hamupipőke", "galamb", "királyfi", "mostoha", "cipő"};
    private final String[] wordsWithLowerCase = {"hamupipőke", "galamb", "királyfi", "mostoha", "cipő"};


    public int[] getNumbers() {
        return numbers;
    }

    public void readFromFile() {

        Map<String, Integer> result;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Cinderella.class.getResourceAsStream("/cinderella.txt")))) {

            result = br.lines()
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .map(this::containsAnyWord)
                    .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        for (int i = 0; i < wordsWithLowerCase.length; i++) {
            if (result.containsKey(wordsWithLowerCase[i])) {
                numbers[i] = result.get(wordsWithLowerCase[i]);
            }
        }
    }

    private String containsAnyWord(String s) {
        String lowS = s.toLowerCase();
        for (String w : wordsWithLowerCase) {
            if (lowS.contains(w)) {
                return w;
            }
        }
        return "";
    }

    public Object[] getMax() {
        Object[] result = new Object[2];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                result[0] = words[i];
                result[1] = max;
            }
        }
        return result;
    }
}

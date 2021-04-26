package hu.nive.ujratervezes.kepesitovizsgaexy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsLength {

    public Map<Integer, Integer> getStatistic(String... s) {
        if (s == null) {
            throw new IllegalArgumentException("The parameter is a must!");
        }

        String text = String.join(" ", s);

        return Arrays.stream(text.split(" "))
                .filter(w -> w.length() > 0)
                .map(String::trim)
                .map(this::removeNotLetter)
                .map(String::length)
                .collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));

    }

    private String removeNotLetter(String word) {
        String[] notLetter = {",", "!", ".", "\"", "?"};
        for (String s : notLetter) {
            word = word.replace(s, "");
        }
        return word;
    }
}

package hu.nive.ujratervezes.kepesitovizsga5.sleepingbeauty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SleepingBeauty {

    public Map<Character, Integer> countCharacters(String s) {
        Path path = Path.of(s);
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .map(String::toLowerCase)
                    .flatMapToInt(String::chars)
                    .filter(Character::isAlphabetic)
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }
}

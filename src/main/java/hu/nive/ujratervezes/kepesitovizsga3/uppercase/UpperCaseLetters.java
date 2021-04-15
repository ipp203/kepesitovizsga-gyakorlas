package hu.nive.ujratervezes.kepesitovizsga3.uppercase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class UpperCaseLetters {

    public int getNumberOfUpperCase(String filename) {
        Path path = Path.of(filename);
        try (Stream<String> lines = Files.lines(path)) {
            return (int) lines
                    .flatMapToInt(String::chars)
                    .filter(Character::isUpperCase)
                    .count();

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }
}

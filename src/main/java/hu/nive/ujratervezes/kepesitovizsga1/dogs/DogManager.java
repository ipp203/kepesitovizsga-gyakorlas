package hu.nive.ujratervezes.kepesitovizsga1.dogs;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DogManager {
    private List<Dog> dogs;


    public DogManager() {
        loadFromFile();
    }

    public String getCountryByExactDogSpecies(String name) {
        if (name == null || name.isBlank()) {
            return "";
        }

        String upperCasedName = name.toUpperCase();

        return dogs.stream()
                .filter(d -> d.getName().equals(upperCasedName))
                .map(Dog::getCountry)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No such dog name found."));
    }

    public List<Dog> getDogsInAlphabeticalOrderByName() {
        return dogs.stream()
                .sorted(Comparator.comparing(Dog::getName, Collator.getInstance(new Locale("hu", "HU"))))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getDogStatistics() {
        return dogs.stream()
                .collect(Collectors.toMap(Dog::getCountry, d -> 1, Integer::sum));
    }

    private void loadFromFile() {
        try (Stream<String> fs = Files.lines(Path.of("src/main/resources/dogs.csv"))) {

            dogs = fs.skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Dog(s[1], s[4], s[5]))
                    .collect(Collectors.toList());

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not load data", ioe);
        }
    }

}

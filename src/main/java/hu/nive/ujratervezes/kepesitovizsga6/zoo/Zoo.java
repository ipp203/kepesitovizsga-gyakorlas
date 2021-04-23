package hu.nive.ujratervezes.kepesitovizsga6.zoo;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {
    private final Set<ZooAnimal> animals = new HashSet<>();
    JdbcTemplate jdbcTemplate;

    public Zoo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void loadAnimals() {
        animals.addAll(jdbcTemplate.query("SELECT animal_name, length_of_member, weight, animal_type FROM animals",
                (rs, row) -> new ZooAnimal(
                        rs.getString("animal_name"),
                        rs.getInt("length_of_member"),
                        rs.getLong("weight"),
                        AnimalType.valueOf(rs.getString("animal_type")))));
    }

    public Set<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }

    public void addAnimal(ZooAnimal animal) {
        animals.add(animal);
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        return animals.stream()
                .max(Comparator.comparingLong(ZooAnimal::getWeight))
                .orElseThrow(() -> new IllegalStateException("Zoo is empty"));
    }


    public int countWeights() {
        return animals.stream()
                .map(ZooAnimal::getWeight)
                .reduce(Long::sum)
                .orElse(0L)
                .intValue();
    }

    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        return animals.stream()
                .filter(a->a.equals(animal))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public ZooAnimal findExactAnimalByName(String name) {
        return animals.stream()
                .filter(a->a.getName().equals(name))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        return animals.stream()
                .sorted(Comparator.comparing(ZooAnimal::getName))
                .collect(Collectors.toList());
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        return animals.stream()
                .collect(Collectors.toMap(ZooAnimal::getType,a->1,Integer::sum));
    }
}

package hu.nive.ujratervezes.kepesitovizsgaexy.airport;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Plane {
    private List<Person> people;

    public Plane(List<Person> people) {
        if (people == null) {
            throw new IllegalArgumentException("Person list is a must!");
        }
        this.people = people;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public Set<Stewardess> getCabinCrew() {
        return people.stream()
                .filter(p -> p.getType() == Type.STEWARDESS)
                .map(p -> (Stewardess) p)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public void relocate() {
        people.stream()
                .filter(p -> p.getType() == Type.PASSENGER)
                .map(p -> (Passenger) p)
                .forEach(Passenger::changeSeat);
    }

    public String findTheOldest() {

        Optional<Person> result = people.stream()
                .filter(p -> p.getType().isNotTravel())
                .max(Comparator.comparingInt(Person::getAge));
        if (result.isPresent()) {
            return result.get().getName();
        } else {
            throw new IllegalStateException("The plane is empty!");
        }
    }

    public String findTheYoungest() {
        Optional<Person> result = people.stream()
                .filter(p -> p.getType().isTravel())
                .filter(p -> p.getAge() != null)
                .min(Comparator.comparingInt(Person::getAge));
        if (result.isPresent()) {
            return result.get().getName();
        } else {
            throw new IllegalStateException("The plane is empty!");
        }
    }

    public Pilot findTheCaptain() {
        return (Pilot) people.stream()
                .filter(p -> p.getType() == Type.PILOT && ((Pilot) p).getPosition() == Position.CAPTAIN)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("The plane is empty!"));
    }

    public Map<String, Passenger> getPassangerList() {
        return people.stream()
                .filter(p -> p.getType().isTravel())
                .filter(p -> p.getType() == Type.PASSENGER)
                .map(p -> (Passenger) p)
                .collect(Collectors.toMap(Passenger::getSeat, Function.identity()));
    }

    public Optional<Integer> howOldTheCaptain() {
        try {
            return Optional.of(findTheCaptain().getAge());
        } catch (IllegalStateException ise) {
            return Optional.empty();
        }
    }

    public void newYearsEve() {
        people.forEach(Person::incAge);
    }

    public void beforeTakeOff() {
        people = people.stream()
                .filter(p -> p.getType().isTravel())
                .collect(Collectors.toList());
    }
}

package hu.nive.ujratervezes.kepesitovizsga4.vaccination;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VaccinationList {
    private MetaData metaData;
    private final Map<LocalTime, Person> vaccinations = new HashMap<>();

    public MetaData getMetaData() {
        return metaData;
    }

    public Map<LocalTime, Person> getVaccinations() {
        return vaccinations;
    }

    public void readFromFile(BufferedReader br) {
        try (br) {
            fillMetaData(br);
            skipHeader(br);
            fillVaccinationsMap(br);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private void fillVaccinationsMap(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(";");

            if (data.length == 7 || data.length == 6) {
                LocalTime time = LocalTime.parse(data[0]);
                vaccinations.put(time, new Person(data[1],
                        Integer.parseInt(data[3]),
                        data[4],
                        data[5],
                        data.length == 7 ? VaccinationType.valueOf(data[6]) : VaccinationType.NONE));
            }
        }
    }

    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
        br.readLine();
    }

    private void fillMetaData(BufferedReader br) throws IOException {
        String line = br.readLine();
        String postalCode = line.split(",")[0].split(" ")[2];
        String townName = line.split(",")[1].strip().split(" ")[0];
        line = br.readLine();
        LocalDate date = LocalDate.parse(line.split(" ")[1]);
        metaData = new MetaData(postalCode, townName, date);
    }

    public Town getTown() {
        return new Town(metaData.getTownName(), metaData.getPostalCode());
    }

    public List<Person> getPersonsMoreThanHundredYearsOld() {
        return vaccinations.values().stream()
                .filter(p -> p.getAge() > 100)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
    }

    public List<Person> getAfternoonPersons() {
        return vaccinations.entrySet().stream()
                .filter(e -> e.getKey().isAfter(LocalTime.of(12, 0)))
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
    }

    public void validateTaj() {
        String wrongTaj = vaccinations.values().stream()
                .filter(Person::notValidateTaj)
                .map(Person::getTaj)
                .reduce("", (s1, s2) -> s1 + ", " + s2);
        if (wrongTaj.length() > 0) {
            throw new IllegalArgumentException(wrongTaj.substring(2));
        }

    }

    public String inviteExactPerson(LocalTime time) {
        return "Kedves " + vaccinations.get(time).getName() + "! Ön következik. Kérem, fáradjon be!";
    }

    public LocalDate getDateOfVaccination() {
        return metaData.getDateOfVaccination();
    }

    public Map<VaccinationType, Long> getVaccinationStatistics() {
        return vaccinations.values().stream()
                .map(Person::getType)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}

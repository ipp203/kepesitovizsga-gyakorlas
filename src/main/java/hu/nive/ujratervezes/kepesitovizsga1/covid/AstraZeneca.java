package hu.nive.ujratervezes.kepesitovizsga1.covid;

import javax.sql.DataSource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AstraZeneca extends Vaccine {

    public AstraZeneca(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {
        List<Person> result = persons.stream()
                .filter(Person::isNotPregnant)
                .filter(Person::hasChronicDisease)
                .collect(Collectors.toList());


        result.addAll(persons.stream()
                .filter(Person::isNotPregnant)
                .filter(Person::hasNotChronicDisease)
                .sorted(Comparator.comparing(Person::isNotPensioner))
                .collect(Collectors.toList()));

        return result;
    }


}

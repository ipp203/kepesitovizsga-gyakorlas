package hu.nive.ujratervezes.kepesitovizsga1.covid;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

public class Pfizer extends Vaccine {

    public Pfizer(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {

        List<Person> pregnancies = persons.stream()
                .filter(Person::isPregnant)
                .collect(Collectors.toList());

        List<Person> pensioners = persons.stream()
                .filter(Person::isPensioner)
                .collect(Collectors.toList());

        List<Person> other = persons.stream()
                .filter(Person::isNotPregnant)
                .filter(Person::isNotPensioner)
                .collect(Collectors.toList());

        pregnancies.addAll(pensioners);
        pregnancies.addAll(other);
        return pregnancies;
    }


}

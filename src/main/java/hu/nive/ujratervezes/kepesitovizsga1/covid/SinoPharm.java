package hu.nive.ujratervezes.kepesitovizsga1.covid;

import javax.sql.DataSource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SinoPharm extends Vaccine {

    public SinoPharm(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {
        return persons.stream()
                .filter(p -> p.hasNotChronicDisease() && p.isNotPregnant())
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }
}

package hu.nive.ujratervezes.kepesitovizsga1.covid;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Vaccine {
    private final DataSource dataSource;
    protected List<Person> persons = new ArrayList<>();

    protected Vaccine(DataSource dataSource) {
        this.dataSource = dataSource;
        loadPersons();
    }

    private void loadPersons() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT person_name, age, chronic_disease, pregnancy FROM registrations")) {

            while (rs.next()) {
                String name = rs.getString("person_name");
                int age = rs.getInt("age");
                Person.ChronicDisease disease = rs.getString("chronic_disease").equals("igen") ? Person.ChronicDisease.YES : Person.ChronicDisease.NO;
                Person.Pregnancy pregnant = rs.getString("pregnancy").equals("igen") ? Person.Pregnancy.YES : Person.Pregnancy.NO;
                persons.add(new Person(name, age, disease, pregnant));
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not load data from database", sqle);
        }
    }

    public abstract List<Person> getVaccinationList();

}

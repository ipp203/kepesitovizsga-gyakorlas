package hu.nive.ujratervezes.kepesitovizsga4.applicants;

import javax.sql.DataSource;
import java.util.List;

public interface ApplicantListGenerator {
    List<Applicant> getListFromDatabase(DataSource dataSource);
}

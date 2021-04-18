package hu.nive.ujratervezes.kepesitovizsga4.applicants;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListByApplicantsPersonal implements ApplicantListGenerator {

//    @Override
//    public List<Applicant> getListFromDatabase(DataSource dataSource) {
//
//        try (Connection conn = dataSource.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT first_name, last_name, phone_number, email FROM applicants")) {
//            List<Applicant> result = new ArrayList<>();
//            while (rs.next()) {
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String phoneNumber = rs.getString("phone_number");
//                String email = rs.getString("email");
//                result.add(new Applicant(firstName, lastName, phoneNumber, email));
//            }
//            return result;
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("Can not select from database.", sqle);
//        }
//    }

    @Override
    public List<Applicant> getListFromDatabase(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate.query("SELECT first_name, last_name, phone_number, email FROM applicants",
                (rs, i) -> new Applicant(rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("email"))
                );
    }
}

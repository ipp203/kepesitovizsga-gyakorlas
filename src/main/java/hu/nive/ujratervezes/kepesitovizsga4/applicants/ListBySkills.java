package hu.nive.ujratervezes.kepesitovizsga4.applicants;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListBySkills implements ApplicantListGenerator {

//    @Override
//    public List<Applicant> getListFromDatabase(DataSource dataSource) {
//        try(Connection conn = dataSource.getConnection();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT first_name, last_name, skill FROM applicants WHERE LENGTH(skill) = 3")){
//
//            List<Applicant> result = new ArrayList<>();
//            while (rs.next()) {
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String skill = rs.getString("skill");
//                result.add(new Applicant(firstName, lastName, skill));
//            }
//            return result;
//
//        } catch (SQLException se){
//            throw new IllegalStateException("Can not select from database.", se);
//        }
//    }
//

    @Override
    public List<Applicant> getListFromDatabase(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query("SELECT first_name, last_name, skill FROM applicants WHERE LENGTH(skill) = 3",
                (rs,i)->new Applicant(rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("skill")));
    }
}

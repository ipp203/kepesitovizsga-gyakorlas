package hu.nive.ujratervezes.kepesitovizsga3.ladybird;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.*;
import java.util.stream.Collectors;

public class LadyBirdJdbcTemplate {
    private final JdbcTemplate jdbcTemplate;

    public LadyBirdJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int numberOfPoints) {

        return jdbcTemplate.query("SELECT hungarian_name FROM ladybirds WHERE number_of_points = ?",
                (rs, i) -> rs.getString("hungarian_name"),
                numberOfPoints);

    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {

        class Data {
            private final int nop;
            private final int count;

            public Data(int nop, int count) {
                this.nop = nop;
                this.count = count;
            }

            public int getNop() {
                return nop;
            }

            public int getCount() {
                return count;
            }
        }

        return jdbcTemplate.query("SELECT number_of_points, COUNT(id) FROM ladybirds GROUP BY number_of_points",
                (rs, i) -> new Data((int) rs.getLong(1), (int) rs.getLong(2)))
                .stream()
                .collect(Collectors.toMap(Data::getNop, Data::getCount));
    }

    public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String partOfName, int numberOfPoints) {

        List<Ladybug> result = jdbcTemplate.query(
                "SELECT hungarian_name, latin_name, genus, number_of_points FROM ladybirds WHERE latin_name LIKE ? AND number_of_points = ?",
                (rs, i) -> new Ladybug(rs.getString("hungarian_name"),
                        rs.getString("latin_name"),
                        rs.getString("genus"),
                        (int) rs.getLong("number_of_points")),
                "%" + partOfName + "%",
                numberOfPoints);

        return new HashSet<>(result);

    }

    public Map<String, Integer> getLadybirdStatistics() {

        Map<String, Integer> result = new HashMap<>();
        jdbcTemplate.query(
                "SELECT genus, COUNT(id) FROM ladybirds GROUP BY genus",
                (rs, i) -> result.put(rs.getString("genus"), rs.getInt("COUNT(id)")));

        return result;
    }
}

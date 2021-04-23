package hu.nive.ujratervezes.kepesitovizsga5.frogprince;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrogPrince {

    public Set<PlayerOfTale> getPlayersOfTale(DataSource dataSource, Tale tale) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<PlayerOfTale> result = jdbcTemplate.query("SELECT player_name, age, tale FROM tales WHERE tale = ?",
                preparedStatement -> preparedStatement.setString(1, tale.toString()),
                (rs, row) -> new PlayerOfTale(rs.getString("player_name"),
                        rs.getInt("age"),
                        Tale.valueOf(rs.getString("tale"))));

        return new HashSet<>(result);
    }
}

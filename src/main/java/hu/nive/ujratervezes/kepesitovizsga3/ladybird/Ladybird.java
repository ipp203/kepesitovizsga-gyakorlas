package hu.nive.ujratervezes.kepesitovizsga3.ladybird;


import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class Ladybird {
    private final DataSource dataSource;

    public Ladybird(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> getLadybirdsWithExactNumberOfPoints(int numberOfPoints) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT hungarian_name FROM ladybirds WHERE number_of_points = ?")) {
            ps.setLong(1, numberOfPoints);
            return getHungarianNameByPreparedStatement(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }

    private List<String> getHungarianNameByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString("hungarian_name"));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select from database", sqle);
        }
    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT number_of_points, COUNT(id) FROM ladybirds GROUP BY number_of_points")) {

            Map<Integer, Integer> result = new HashMap<>();
            while (rs.next()) {
                int nop = (int) rs.getLong("number_of_points");
                int nolb = (int) rs.getLong("COUNT(id)");
                result.put(nop, nolb);
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }

    public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String partOfName, int numberOfPoints) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT hungarian_name, latin_name, genus, number_of_points FROM ladybirds WHERE latin_name LIKE ? AND number_of_points = ?")) {
            ps.setString(1, "%" + partOfName + "%");
            ps.setLong(2, numberOfPoints);
            return getLadybugsByPreparedStatement(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }

    private Set<Ladybug> getLadybugsByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            Set<Ladybug> result = new HashSet<>();
            while (rs.next()) {
                String hn = rs.getString("hungarian_name");
                String ln = rs.getString("latin_name");
                String genus = rs.getString("genus");
                int nop = (int) rs.getLong("number_of_points");
                result.add(new Ladybug(hn, ln, genus, nop));
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select from database.", sqle);
        }
    }

    public Map<String, Integer> getLadybirdStatistics() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT genus, COUNT(id) FROM ladybirds GROUP BY genus")) {

            Map<String, Integer> result = new HashMap<>();
            while (rs.next()) {
                String genus = rs.getString("genus");
                long numb = rs.getLong("COUNT(id)");
                result.put(genus, (int) numb);
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }
}

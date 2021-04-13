package hu.nive.ujratervezes.kepesitovizsga2.dictionary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dictionary {
    private DataSource dataSource;

    public Dictionary(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getEnglishWord(String hungarianWord) {
        return getWordFromDatabase("angol", "magyar", hungarianWord);
    }

    public String getHungarianWord(String englishWord) {
        return getWordFromDatabase("magyar", "angol", englishWord);
    }

    private String getWordFromDatabase(String columnFrom, String columnWhere, String word) {

        String sqlString = "SELECT " + columnFrom + " FROM words WHERE " + columnWhere + " = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlString)) {

            ps.setString(1, word);

            return getWordByPreparedStatement(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database ", sqle);
        }
    }

    private String getWordByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString(1);
            }
            throw new IllegalArgumentException("No such word in dictionary.");

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not query from database ", sqle);
        }
    }
}

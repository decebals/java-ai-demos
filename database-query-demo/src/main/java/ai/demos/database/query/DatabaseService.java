package ai.demos.database.query;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Execute a query against the database and return the result as a string.
     *
     * @param query the SQL query to execute
     * @return the result of the query as a string
     */
    public String executeQuery(String query) {
        List<String> results = jdbcTemplate.query(query, (rs, rowNum) -> rs.getString(1));
        return String.join("\n", results);
    }

}

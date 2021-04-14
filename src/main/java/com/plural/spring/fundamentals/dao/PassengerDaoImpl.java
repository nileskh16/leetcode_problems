package com.plural.spring.fundamentals.dao;

import com.plural.spring.fundamentals.models.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengerMap = new HashMap<>();

    public static Map<Integer, Passenger> getPassengerMap() {
        return passengerMap;
    }

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Passenger> rowMapper = new RowMapper<Passenger>() {
        @Override
        public Passenger mapRow(ResultSet resultSet, int i) throws SQLException {
            Passenger passenger = new Passenger();
            passenger.setName(resultSet.getString("name"));
            passenger.setCountry(resultSet.getString("country"));
            return passenger;
        }
    };

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Passenger getById(int id) {
        String sqlQuery = "SELECT * FROM PASSENGERS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id);
    }

    @Override
    public Passenger getPassenger(int id) {
        if (null != passengerMap.get(id)) {
            System.out.println("Returning the entry from the cache");
            return passengerMap.get(id);
        }
        return getById(id);
    }
}

/*package com.unibuc.airlinebooking.repository;

import com.unibuc.airlinebooking.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements DaoRepository<User> {

    private Long id = 0L;
    private final HashMap<Long, User> userList = new HashMap<>();

    @Override
    public User save(User user) {
        user.setAccountCreated(LocalDateTime.now());
        userList.put(id++, user);
        return user;
    }

    @Override
    public boolean delete(User object) {
        Optional<Long> userKey = userList.keySet()
                .stream()
                .filter(key -> userList.get(key).equals(object))
                .findAny();
        if (userKey.isPresent()) {
            userList.remove(userKey.get(), object);
            return true;
        }
        return false;
    }

    @Override
    public User getOne(Long id) {
        return userList.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userList.values());
    }
}
*/

package com.unibuc.airlinebooking.repository;
import com.unibuc.airlinebooking.model.FlightInformation;
import com.unibuc.airlinebooking.model.Plane;
import com.unibuc.airlinebooking.model.Reservation;
import com.unibuc.airlinebooking.model.User;
import com.unibuc.airlinebooking.domain.UserDetails;
import com.unibuc.airlinebooking.exception.EntityNotFoundException;
import com.unibuc.airlinebooking.domain.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.*;
import java.util.Optional;

@Repository
public class UserRepository {
    private String username;
    private String password;
    private String name;
    private String email;
    private UserType userType;
    private LocalDateTime accountCreated;
    private int age;
    private String gender;
    private String phone;

  /*   private Long id = 0L;
    private final HashMap<Long, User> userList = new HashMap<>();


    public User save(User user) {
        user.setAccountCreated(LocalDateTime.now());
        userList.put(id++, user);
        return user;
    }


    public boolean delete(User object) {
        Optional<Long> userKey = userList.keySet()
                .stream()
                .filter(key -> userList.get(key).equals(object))
                .findAny();
        if (userKey.isPresent()) {
            userList.remove(userKey.get(), object);
            return true;
        }
        return false;
    }


    public User getOne(Long id) {
        return userList.get(id);
    }


    public List<User> getAll() {
        return new ArrayList<>(userList.values());
    }
*/
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public User save(User user) {
        String saveUsersSql = "INSERT INTO users (username, password, name, email, user_type, account_created, age, gender, phone)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(saveUsersSql, user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getUserType(),
                LocalDateTime.now(), user.getAge(), user.getGender(), user.getPhone());

        User savedUser = getUserWith(user.getUsername());
        FlightInformation flightInformation = user.getFlightInformation();

        if (null != flightInformation) {
            String saveUserDetailsSql = "INSERT INTO flight_info (flightnumber, starting_point, ending_point, departureTime, arrivalTime, description, plane, flightcreated, seatsLeft) VALUES (?, ?, ?)";
            jdbcTemplate.update(saveUserDetailsSql, flightInformation.getFlightNumber(), flightInformation.getFrom(), flightInformation.getTo(), flightInformation.getDepartureTime(),
                    flightInformation.getArrivalTime(), flightInformation.getDescription(), flightInformation.getPlane(), flightInformation.getReservations(), flightInformation.getSeatsLeft(), LocalDateTime.now());

            FlightInformation savedFlightInformation = getUserDetailsWith(flightInformation.getFlightNumber());
            savedUser.setFlightInformation(savedFlightInformation);

            String saveUserUserDetailsSql = "INSERT INTO users_and_flight_info (users, flight_info) VALUES (?, ?)";
            jdbcTemplate.update(saveUserUserDetailsSql, savedUser.getId(), savedFlightInformation.getId());
        }
        return savedUser;
    }



    public User get(String username) {
        return getUserWith(username);
    }

    private User getUserWith(String username) {
        String selectSql = "SELECT * from users WHERE users.username = ?";

        RowMapper<User> rowMapper = (resultSet, rowNo) -> User.builder()
                .id(resultSet.getLong("id"))
                .username(resultSet.getString("username"))
                .name(resultSet.getString("name"))
                .userType(UserType.valueOf(resultSet.getString("user_type")))
                .build();

        List<User> users = jdbcTemplate.query(selectSql, rowMapper, username);

        if (null != users && !users.isEmpty()) {
            return users.get(0);
        }
        throw new EntityNotFoundException(username);
    }

    private FlightInformation getUserDetailsWith(String flightnumber) {
        String selectSql = "SELECT * from flight_info WHERE flight_info.flightnumber = ?";

        RowMapper<FlightInformation> rowMapper = (resultSet, rowNo) -> FlightInformation.builder()
                .id(resultSet.getLong("id"))
                .build();

        List<FlightInformation> flightDetails = jdbcTemplate.query(selectSql, rowMapper, flightnumber);

        if (null != flightDetails && !flightDetails.isEmpty()) {
            return flightDetails.get(0);
        }
        throw new EntityNotFoundException(flightnumber);
    }

}

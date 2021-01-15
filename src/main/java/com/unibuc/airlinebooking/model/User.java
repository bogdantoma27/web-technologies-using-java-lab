package com.unibuc.airlinebooking.model;

import com.unibuc.airlinebooking.domain.UserType;
import com.unibuc.airlinebooking.model.Reservation;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private UserType userType;
    private FlightInformation flightInformation;
    private LocalDateTime accountCreated;

    @Column
    private int age;

    @Column
    private String gender;

    // The uniqueness of phone numbers must be enforced.
    @Column(unique = true)
    private String phone;

    // reservation made by the passenger should also be deleted.
    @OneToMany(mappedBy = "passengerFKey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    /**
     * Instantiates a new Passenger.
     */
    public User() {
    }

    /**
     * Instantiates a new Passenger.
     *
     * @param age       the age
     * @param gender    the gender
     * @param phone     the phone
     */
    public User(Long id, String username, String password, String name, String email, UserType userType, LocalDateTime accountCreated, int age, String gender, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.accountCreated = accountCreated;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets username.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets codCategory.
     *
     * @return the codCategory
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Sets codCategory.
     *
     * @param userType the userCategory
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Gets accountCreated.
     *
     * @return the accountCreated
     */
    public LocalDateTime getAccountCreated() {
        return accountCreated;
    }

    /**
     * Sets accountCreated.
     *
     * @param accountCreated the accountCreated
     */
    public void setAccountCreated(LocalDateTime accountCreated) {
        this.accountCreated = accountCreated;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets reservations.
     *
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets reservations.
     *
     * @param reservations the reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}

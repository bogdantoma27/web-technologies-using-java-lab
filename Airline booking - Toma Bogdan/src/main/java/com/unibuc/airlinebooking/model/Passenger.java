package com.unibuc.airlinebooking.model;

import com.unibuc.airlinebooking.domain.UserType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The type Passenger.
 */
@Entity
@Table(name = "passenger")
public class Passenger {

    private String username;
    private String password;
    private String name;
    private String email;
    private UserType codCategory;
    private LocalDateTime accountCreated;

    @Column
    private String id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

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
    public Passenger() {
    }

    /**
     * Instantiates a new Passenger.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param age       the age
     * @param gender    the gender
     * @param phone     the phone
     */
    public Passenger(String firstname, String lastname, int age, String gender, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
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
    public UserType getCodCategory() {
        return codCategory;
    }

    /**
     * Sets codCategory.
     *
     * @param codCategory the codCategory
     */
    public void setCodCategory(UserType codCategory) {
        this.codCategory = codCategory;
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
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
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
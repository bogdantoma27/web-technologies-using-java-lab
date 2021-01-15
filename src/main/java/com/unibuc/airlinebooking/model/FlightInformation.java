package com.unibuc.airlinebooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class FlightInformation {

    private Long id;
    private int price;
    private String flightNumber;
    private String from;
    private String to;
    private String departureTime;
    private String arrivalTime;
    private String description;
    private Plane plane;
    private List<Reservation> reservations;
    private int seatsLeft;
    private LocalDateTime flightcreated;

    /**
     * Instantiates a new Flight.
     */
    public FlightInformation() {
    }

    /**
     * Instantiates a new Flight.
     *
     * @param flightNumber  the flight number
     * @param price         the price
     * @param from          the from
     * @param to            the to
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param description   the description
     * @param seatsLeft     the seats left
     * @param plane         the plane
     */
    public FlightInformation(String flightNumber, int price, String from, String to, String departureTime, String arrivalTime,
                  String description, int seatsLeft, Plane plane) {
        this.flightNumber = flightNumber;
        this.price = price;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.description = description;
        this.seatsLeft = seatsLeft;
        this.plane = plane;
    }

    /**
     * Gets flight number.
     *
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets flight number.
     *
     * @param flightNumber the flight number
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets departure time.
     *
     * @return the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets departure time.
     *
     * @param departureTime the departure time
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Gets arrival time.
     *
     * @return the arrival time
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets arrival time.
     *
     * @param arrivalTime the arrival time
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets plane.
     *
     * @return the plane
     */
    public Plane getPlane() {
        return plane;
    }

    /**
     * Sets plane.
     *
     * @param plane the plane
     */
    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    /**
     * Gets reservations.
     *
     * @return the reservations
     */
    @JsonIgnore
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

    /**
     * Gets seats left.
     *
     * @return the seats left
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }

    /**
     * Sets seats left.
     *
     * @param seatsLeft the seats left
     */
    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    /**
     * Increment seats left by one.
     */
    public void incrementSeatsLeftByOne() {
        seatsLeft += 1;
    }

    /**
     * Decrement seats left by one boolean.
     *
     * @return the boolean
     */
    public boolean decrementSeatsLeftByOne() {

        return --seatsLeft == -1;
    }

}

CREATE TABLE users
(
    id              BIGINT      NOT NULL AUTO_INCREMENT,
    username        VARCHAR(50) NOT NULL,
    password        VARCHAR(50),
    name            VARCHAR(50),
    email           VARCHAR(50),
    user_type       VARCHAR(50),
    account_created datetime,
    age             VARCHAR(50),
    gender          VARCHAR(50),
    phone           VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE flight_info (
    id BIGINT NOT NULL AUTO_INCREMENT,
    flightnumber VARCHAR(50) NOT NULL,
    starting_point  VARCHAR(50),
    ending_point    VARCHAR(50),
    departureTime   VARCHAR(50),
    arrivalTime     VARCHAR(50),
    description     VARCHAR(50),
    plane           VARCHAR(50),
    flightcreated   INT,
    seatsLeft       INT,

    PRIMARY KEY (id)
);

CREATE TABLE users_and_flight_info (
    id BIGINT NOT NULL AUTO_INCREMENT,
    users BIGINT NOT NULL,
    flight_info BIGINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (users) REFERENCES users(id),
    FOREIGN KEY (flight_info) REFERENCES flight_info(id)
)

SET MODE MySQL;
SET IGNORECASE = TRUE;


DROP TABLE IF EXISTS repair_Cafe;
DROP TABLE IF EXISTS repair_Booking;


CREATE TABLE IF NOT EXISTS repair_Cafe
(
    cafe_id         INTEGER AUTO_INCREMENT NOT NULL,
    name            VARCHAR(200) NOT NULL,
    address         VARCHAR(2000) NOT NULL,
    PRIMARY KEY(`cafe_id`)
    )
    ENGINE = INNODB;



CREATE TABLE IF NOT EXISTS repair_Booking
(
    booking_id      INTEGER AUTO_INCREMENT NOT NULL,
    firstName       VARCHAR(200) NOT NULL,
    lastName        VARCHAR(200) NOT NULL,
    email           VARCHAR(200) NOT NULL,
    repairDate      DATE NOT NULL,
    location        VARCHAR(1000) NOT NULL,
    PRIMARY KEY(`booking_id`)
    )
    ENGINE = INNODB;
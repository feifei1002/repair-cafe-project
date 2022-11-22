SET MODE MySQL;
SET IGNORECASE = TRUE;

-- -----------------------------------------------------
-- Table `repair_Cafe`
-- -----------------------------------------------------

DROP TABLE IF EXISTS repair_Cafe;


CREATE TABLE IF NOT EXISTS repair_Cafe
(
    cafe_id         varchar(15)  not null,
    name            varchar(200) not null,
    address         varchar(2000) not null,
    primary key (`cafe_id`)
    )

-- -----------------------------------------------------
-- Table `repair_Booking`
-- -----------------------------------------------------

DROP TABLE IF EXISTS repair_Booking;


CREATE TABLE IF NOT EXISTS repair_Booking
(
    booking_id      varchar(15)  not null,
    firstName       varchar(200) not null,
    lastName        varchar(200) not null,
    email           varchar(200) not null
    primary key (`booking_id`)
    )
    engine = InnoDB;
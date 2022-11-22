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
    engine = InnoDB;
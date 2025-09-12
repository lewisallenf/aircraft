CREATE TABLE aircraft
(
    id       BIGINT NOT NULL,
    airframe VARCHAR(255) NULL,
    pilot    VARCHAR(255) NULL,
    CONSTRAINT pk_aircraft PRIMARY KEY (id)
);
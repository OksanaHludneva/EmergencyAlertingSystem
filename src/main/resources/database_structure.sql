SET GLOBAL time_zone = '+2:00';
SET SQL_SAFE_UPDATES = 0;

CREATE DATABASE IF NOT EXISTS java2728_eas;

USE java2728_eas;

CREATE TABLE IF NOT EXISTS contacts (
    id INT NOT NULL AUTO_INCREMENT,
    phoneNr VARCHAR(20) NOT NULL,
    region VARCHAR (50) NOT NULL,
    createdAt timestamp default current_timestamp,
    updatedAt timestamp default current_timestamp on update current_timestamp,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS regions (
    id INT NOT NULL AUTO_INCREMENT,
    region varchar(50) NOT NULL,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS accidents (
    id INT NOT NULL AUTO_INCREMENT,
    accidentName VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    messageText VARCHAR (200),
    regionsId INT NOT NULL,
    primary key (id),
    foreign key (regionsId) REFERENCES regions (id)
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR (200) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    primary key (id)
);

INSERT INTO contacts (phoneNr, region) VALUES 
(+371, 'Riga'),
(+371, 'Riga');

UPDATE contacts SET phoneNr=concat('+', phoneNr);

INSERT INTO regions (region) VALUES
('Riga'),
('Vidzeme'),
('Kurzeme'),
('Zemgale'),
('Latgale');

INSERT INTO accidents (accidentName, description, regionsId) VALUES
('Weather alert', 'Flood or any other natural disaster', 1),
('Threat, attack', 'Bomb threat, suspicious object, attack to entity or country', 2),
('Public health', 'Cardiac arrest, medical emergency', 3),
('Hazardous spill', 'Infectious, harmful substance leakage', 4),
('Evacuation', 'Facility, region', 5),
('Infrastructure loss or failure', 'Electricity or any other infrastructure', 1),
('External disaster', 'Mass casualties, emergency service overload', 2),
('Hostage taking', 'Person or group having control over other/-s with demands', 3),
('Fire, smoke', 'Destructive burning, possible casualties', 4),
('Active attacker or shooter', 'Person or group carrying deadly weapons', 5),
('Violent situation', 'Of any type', 1),
('Missing adult', 'Not know location, absence of adult', 2),
('Missing child', 'Not know location, absence of child', 3),
('Heightened situation', 'Any combinations of any codes', 4);

INSERT INTO users (username, password, name, email, phone) VALUES
('testUser', 'testUser', 'Test User', 'testUser@eas.com', 12345678);

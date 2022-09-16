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
    codeColor VARCHAR (50) NOT NULL,
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
(+37129663132, 'Riga'),
(+37126311662, 'Riga');

INSERT INTO contacts (phoneNr, region) VALUES
(+37129663132, 'Vidzeme'),
(+37126311662, 'Vidzeme');

INSERT INTO contacts (phoneNr, region) VALUES
(+37129663132, 'Kurzeme'),
(+37126311662, 'Kurzeme');

INSERT INTO contacts (phoneNr, region) VALUES
(+37129663132, 'Zemgale'),
(+37126311662, 'Zemgale');

INSERT INTO contacts (phoneNr, region) VALUES
(+37129663132, 'Latgale'),
(+37126311662, 'Latgale');

UPDATE contacts SET phoneNr=concat('+', phoneNr);

INSERT INTO regions (region) VALUES
('Riga'),
('Vidzeme'),
('Kurzeme'),
('Zemgale'),
('Latgale');

INSERT INTO accidents (codeColor, accidentName, description, regionsId) VALUES
('Aqua', 'Weather alert', 'Flood or any other natural disaster', 1),
('Black', 'Threat, attack', 'Bomb threat, suspicious object, attack to entity or country', 2),
('Blue', 'Public health', 'Cardiac arrest, medical emergency', 3),
('Brown', 'Hazardous spill', 'Infectios, harmful substance leakage', 4),
('Green', 'Evacuation', 'Facility, region', 5),
('Grey', 'Infrastructure loss or failure', 'Electricity or any other infrastructure', 1),
('Orange', 'External disaster', 'Mass casulties, emergency service overload', 2),
('Purple', 'Hostage taking', 'Person or group having control over other/-s with demands', 3),
('Red', 'Fire, smoke', 'Destructive burning, possible casulties', 4),
('Silver', 'Active attacker or shooter', 'Person or group carrying deadly weapons', 5),
('White', 'Violent situation', 'Of any type', 1),
('Yellow', 'Missing adult', 'Not know location, absence of adult', 2),
('Amber', 'Missing child', 'Not know location, absence of child', 3),
('Pink', 'Heightened situation', 'Any combinations of any codes', 4);

INSERT INTO users (username, password, name, email, phone) VALUES
('testUser', 'testUser', 'Test User', 'testUser@eas.com', 12345678);

SELECT * FROM contacts;
SELECT * FROM accidents;
SELECT * FROM regions;

SELECT phoneNr FROM contacts WHERE region = "Riga";
SELECT * FROM contacts WHERE region = "Vidzeme";

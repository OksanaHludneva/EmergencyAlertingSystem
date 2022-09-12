/*DROP DATABASE IF EXISTS eas;*/

SET GLOBAL time_zone = '+2:00';

CREATE DATABASE IF NOT EXISTS eas;

USE eas;

SET GLOBAL time_zone = '+2:00';

CREATE DATABASE IF NOT EXISTS eas;

USE eas;

CREATE TABLE IF NOT EXISTS contacts (
    id INT NOT NULL AUTO_INCREMENT,
    phoneNr VARCHAR(20) NOT NULL UNIQUE,
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
    phone VARCHAR(20) NOT NULL UNIQUE,
    primary key (id)
);

INSERT INTO contacts (phoneNr, region) VALUES
(+37126844115, 'Zemgale'),
(+37129658889, 'Vidzeme'),
(+37126444585, 'Latgale'),
(+37129444789, 'Kurzeme'),
(+37120018022, 'Kurzeme'),
(+37129333457, 'Kurzeme'),
(+37126364680, 'Latgale'),
(+37126721348, 'Latgale'),
(+37129000754, 'Vidzeme'),
(+37126565612, 'Zemgale');

INSERT INTO regions (region) VALUES
('Riga'),
('Vidzeme'),
('Kurzeme'),
('Zemgale'),
('Latgale');

INSERT INTO accidents (codeColor, accidentName, description, regionsId) VALUES
('Aqua', 'Weather alert', 'Flood or any other natural disaster', 1),
('Black', 'Threat, attack', 'Bomb threat, suspicious object, attack to entity or country', 1),
('Blue', 'Public health', 'Cardiac arrest, medical emergency', 1),
('Brown', 'Hazardous spill', 'Infectios, harmful substance leakage', 1),
('Green', 'Evacuation', 'Facility, region', 1),
('Grey', 'Infrastructure loss or failure', 'Electricity or any other infrastructure', 1),
('Orange', 'External disaster', 'Mass casulties, emergency service overload', 1),
('Purple', 'Hostage taking', 'Person or group having control over other/-s with demands', 1),
('Red', 'Fire, smoke', 'Destructive burning, possible casulties', 1),
('Silver', 'Active attacker or shooter', 'Person or group carrying deadly weapons', 1),
('White', 'Violent situation', 'Of any type', 1),
('Yellow', 'Missing adult', 'Not know location, absence of adult', 1),
('Amber', 'Missing child', 'Not know location, absence of child', 1),
('Pink', 'Heightened situation', 'Any combinations of any codes', 1);

INSERT INTO users (username, password, name, email, phone) VALUES
('testUser', 'testUser', 'Test User', 'testUser@eas.com', 12345678);
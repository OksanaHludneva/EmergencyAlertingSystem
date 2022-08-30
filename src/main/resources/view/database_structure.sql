/*DROP DATABASE IF EXISTS eas;*/

SET GLOBAL time_zone = '+2:00';

CREATE DATABASE IF NOT EXISTS eas;

USE eas;

-- Do we add some time, date? Line 14-15
CREATE TABLE IF NOT EXISTS contacts (
    id INT NOT NULL AUTO_INCREMENT,
    phoneNr VARCHAR(20) NOT NULL,
    region VARCHAR (100) NOT NULL,
    createdAt timestamp default current_timestamp,
    updatedAt timestamp default current_timestamp on update current_timestamp,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS accident (
    id INT NOT NULL AUTO_INCREMENT,
    codeColor VARCHAR (50) NOT NULL,
    accidentName VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    messageText VARCHAR (200),
    primary key (id)
);

INSERT INTO contacts (phoneNr, region) VALUES
(26844115, 'Zemgale'),
(29658889, 'Vidzeme'),
(26444585, 'Latgale'),
(29444789, 'Kurzeme'),
(20018022, 'Kurzeme'),
(29333457, 'Kurzeme'),
(26364680, 'Latgale'),
(26721348, 'Latgale'),
(29000754, 'Vidzeme'),
(26565612, 'Zemgale');

INSERT INTO accident (codeColor, accidentName, description) VALUES
('Aqua', 'Weather alert', 'Flood or any other natural disater'),
('Black', 'Threat, attack', 'Bomb threat, suspicious object, attack to entity or country'),
('Blue', 'Public health', 'Cardiac arrest, medical emergency'),
('Brown', 'Hazardous spill', 'Infectios, harmful substance leakage'),
('Green', 'Evacuation', 'Facility, region'),
('Grey', 'Infrastructure loss or failure', 'Electricity or any other infrastructure'),
('Orange', 'External disaster', 'Mass casulties, emergency service overload'),
('Purple', 'Hostage taking', 'Person or group having control over other/-s with demands'),
('Red', 'Fire, smoke', 'Destructive burning, possible casulties'),
('Silver', 'Active attacker or shooter', 'Person or group carrying deadly weapons'),
('White', 'Violent situation', 'Of any type'),
('Yellow', 'Missing adult', 'Not know location, absence of adult'),
('Amber', 'Mising child', 'Not know location, absence of child'),
('Pink', 'Hightened situation', 'Any combinations of any codes');
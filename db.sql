-- Satellite-Based Communication Service Application by Seval Capraz
-- Satellite Table
CREATE TABLE Satellite (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(50),
    type VARCHAR(15),
    noradId INTEGER,
    latitude DECIMAL(10, 6),
    longitude DECIMAL(10, 6),
    altitude NUMERIC(10, 2),
    speed NUMERIC(10, 2),
    azimuth NUMERIC(10, 2),
    elevation NUMERIC(10, 2),
    rightAscension TIME,
    declination NUMERIC(10, 2)
);

-- GroundStation Table
CREATE TABLE GroundStation (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(50),
    stationId INTEGER,
    latitude DECIMAL(10, 6),
    longitude DECIMAL(10, 6),
    altitude NUMERIC(10, 2),
    azimuth NUMERIC(10, 2),
    elevation NUMERIC(10, 2),
    address VARCHAR(255)
);

-- CommunicationWindow Table
CREATE TABLE CommunicationWindow (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    startTime TIMESTAMP,
    endTime TIMESTAMP,
    satelliteId BIGINT,
    groundStationId BIGINT,
    FOREIGN KEY (satelliteId) REFERENCES Satellite (id),
    FOREIGN KEY (groundStationId) REFERENCES GroundStation (id)
);

-- TrackingOfCommunication Table
CREATE TABLE TrackingOfCommunication (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    groundStationId BIGINT,
    satelliteId BIGINT,
    trackingStartTime TIMESTAMP,
    trackingEndTime TIMESTAMP,
    azimuth NUMERIC(10, 2),
    elevation NUMERIC(10, 2),
    FOREIGN KEY (groundStationId) REFERENCES GroundStation (id),
    FOREIGN KEY (satelliteId) REFERENCES Satellite (id)
);

Create test data:

-- Insert example satellites into the Satellite table

INSERT INTO Satellite (name, type, noradId, latitude, longitude, altitude, speed, azimuth, elevation, rightAscension, declination)
VALUES
    ('Connecta T1.1', 'LEO', 52739, 66.070000, -156.520000, 493.12, 7.62, 2.30, -33.60, '21:34:02', 24.73),
    ('Connecta T1.2', 'LEO', 55012, -5.234000, 120.567000, 700.00, 8.50, 15.00, 22.00, '10:22:15', -12.45),
    ('Connecta T2.1', 'LEO', 56210, 34.123456, 140.654321, 600.45, 6.20, 75.30, 10.20, '03:15:00', 8.60),
    ('Connecta T3.1', 'LEO', 58256, 45.678900, -67.890000, 450.00, 7.80, 130.45, -12.90, '16:45:25', 23.20),
    ('Connecta T3.2', 'LEO', 58268, 20.555555, 30.666666, 520.20, 7.00, 40.00, -25.00, '08:50:30', 15.90);

-- Insert example ground stations into the GroundStation table

INSERT INTO GroundStation (name, latitude, longitude, altitude, azimuth, elevation, stationId, address)
VALUES
    ('GS-A', 39.925533, 32.866287, NULL, NULL, NULL, 1, 'Ankara Turkey'),
    ('GS-B', 79.004959, 17.666016, NULL, NULL, NULL, 2, 'Svalbard Norway'),
    ('GS-C', -33.865143, 151.209900, NULL, NULL, NULL, 3, 'Sydney Australia');

-- Create Users
CREATE TABLE users ( username VARCHAR(50) NOT NULL PRIMARY KEY, password VARCHAR(100) NOT NULL, enabled BOOLEAN NOT NULL ); 

CREATE TABLE authorities ( username VARCHAR(50) NOT NULL, authority VARCHAR(50) NOT NULL, FOREIGN KEY (username) REFERENCES users(username) );

-- Insert dummy users
INSERT INTO users (username, password, enabled) VALUES
('user1', '$2a$10$DOWSDU2rQ3O8gZf4YJZhaOQl1UJFA9pWbNm/ZD4U7/uOtx9m/P0XO', true),
('user2', '$2a$10$KtSR6UgjkPkwgFubEJ5JneJdXAA3q6j7gqfRuVZZgMhaSg8c2bE.G', true);

-- Insert authorities for users
INSERT INTO authorities (username, authority) VALUES
('user1', 'USER'),
('user2', 'USER');





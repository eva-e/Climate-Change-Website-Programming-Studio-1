-- Create tables for Semester 1 2023 CTG example ER Model
PRAGMA foreign_keys = OFF;
drop table if exists Country;
drop table if exists Date;
PRAGMA foreign_keys = ON;

CREATE TABLE Country (
   CountryCode TEXT NOT NULL,
   CountryName Text,
   PRIMARY KEY (CountryCode)
);

CREATE TABLE Date (
   Year NOT NULL,
   PRIMARY KEY (Year)
);

CREATE TABLE CountryTempObservation (
   CountryCode TEXT NOT NULL,
   Year INTEGER NOT NULL,
   AvgTemp REAL,
   MinTemp REAL,
   MaxTemp REAL,
   Population INTEGER,
   PRIMARY KEY (CountryCode, Year),
   FOREIGN KEY (CountryCode) REFERENCES Country (CountryCode),
   FOREIGN KEY (Year) REFERENCES Date (Year)
);
CREATE TABLE Population (
    CountryName TEXT    NOT NULL,
    CountryCode TEXT    NOT NULL,
    Year        INTEGER,
    Population  INTEGER,
    PRIMARY KEY (
        CountryName,
        CountryCode,
        Year
    ),
    FOREIGN KEY (
        Year
    )
    REFERENCES Date (Year) 
);


CREATE TABLE CityTempObservation (
    Year    INTEGER NOT NULL,
    AvgTemp REAL,
    MinTemp REAL,
    MaxTemp REAL,
    City    TEXT    NOT NULL,
    Country TEXT    NOT NULL,
    Lat     TEXT,
    Lon     TEXT,
    PRIMARY KEY (
        City,
        Country,
        Year
    ),
    FOREIGN KEY (
        Year
    )
    REFERENCES Date (Year) 
);


CREATE TABLE StateTempObservation (
    Year    INTEGER NOT NULL,
    AvgTemp REAL,
    MinTemp REAL,
    MaxTemp REAL,
    State   TEXT    NOT NULL,
    Country TEXT    NOT NULL,
    PRIMARY KEY (
        State,
        Country,
        Year
    ),
    FOREIGN KEY (
        Year
    )
    REFERENCES Date (Year) 
);

CREATE TABLE GlobalYearlyTemp (
    Year    INTEGER NOT NULL,
    AvgTemp REAL,
    MinTemp REAL,
    MaxTemp REAL,
    PRIMARY KEY (
        Year
    )
);

-- sqlite3

-- a.
-- Translate the diagram above by writing the SQL CREATE TABLE statements to represent this E/R diagram.
-- Include all key constraints; you should specify both primary and foreign keys.
-- Make sure that your statements are syntactically correct (you might want to check them using SQLite, 
-- Azure SQL Server, or another relational database).
PRAGMA foreign_keys=ON;

CREATE TABLE IF NOT EXISTS InsuranceCo (
	name varchar(56) PRIMARY KEY,
    phone varchar(16)
);

CREATE TABLE IF NOT EXISTS Person (
	ssn INTEGER PRIMARY KEY,
    name varchar(16)
);

CREATE TABLE IF NOT EXISTS Driver (
	ssn INTEGER PRIMARY KEY,
    driverID INTEGER,
    FOREIGN KEY (ssn) references Person(ssn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS NonProfessionalDriver (
    ssn INTEGER PRIMARY KEY,
    FOREIGN KEY (ssn) references Driver(ssn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ProfessionalDriver (
    ssn INTEGER PRIMARY KEY,
    medicalHistory TEXT,
    FOREIGN KEY (ssn) references Driver(ssn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Vehicle (
	licensePlate varchar(12) PRIMARY KEY,
    year int,
    owner_ssn INTEGER,
    insuranceCo_name varchar(56),
    maxLiability int,
    FOREIGN KEY (owner_ssn) references Person(ssn) ON DELETE CASCADE,
    FOREIGN KEY (insuranceCo_name) references InsuranceCo(name) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Car (
    licensePlate varchar(12) PRIMARY KEY,
    make varchar(56),
    FOREIGN KEY (licensePlate) references Vehicle(licensePlate) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Truck (
    licensePlate varchar(12) PRIMARY KEY,
    capacity int,
    operator_ssn INTEGER,
    FOREIGN KEY (licensePlate) references Vehicle(licensePlate) ON DELETE CASCADE,
    FOREIGN KEY (operator_ssn) references ProfessionalDriver(ssn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Drives (
    licensePlate varchar(12),
    ssn INTEGER,
    PRIMARY KEY (licensePlate,ssn),
    FOREIGN KEY (licensePlate) references Car(licensePlate) ON DELETE CASCADE,
    FOREIGN KEY (ssn) references NonProfessionalDriver(ssn) ON DELETE CASCADE
);

-- b. 
-- Which relation in your relational schema represents the relationship "insures" in the E/R diagram? 
-- Why is that your representation?
-- "FOREIGN KEY (insuranceCo_name) references InsuranceCo(name) ON DELETE CASCADE" and "maxLiability int" in table Vehicle
-- It represents the many to one relationship from Vehicles to InsuranceCo

-- c.
-- Compare the representation of the relationships "drives" and "operates" in your schema, and explain why they are different.
-- "drives" is a many-to-many relationship, so we need a table Drives to represent it 
-- "operates" is a many-to-one relationship, we can just use a foreign key to represent it
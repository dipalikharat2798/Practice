use ARSDB
create table AirCrafts(
 AcID INT Primary Key,
 AcNumber Varchar(32) Not null,
 Capacity int not null,
 MfdBy Varchar(128) not null,
 MfdOn Datetime not null
)

INSERT INTO AirCrafts(AcID, AcNumber, Capacity, MfdBy, MfdOn)VALUES(1, 'ATR 72-500', 75, 'Alenia Aeronotica', '23 April 1998')

INSERT INTO AirCrafts(AcID, AcNumber, Capacity, MfdBy, MfdOn)VALUES(2, 'BTS 45-900', 69, 'B/E Aerospace', '23 May 2009')

CREATE TABLE Route(
RtID INT PRIMARY KEY,
Airport Varchar(32) NOT NULL,
Destination Varchar(32) NOT NULL,
RouteCode Varchar(16) NOT NULL UNIQUE
)

    
INSERT INTO Route Values (1, 'Kathmandu', 'Pokhara', 'KTM-PKR');

INSERT INTO Route Values (2, 'Pune', 'Hyderabad', 'PUN-HYD');


CREATE TABLE AirFare(
AfID INT,
Route INT,
Fare money,
FSC money,
PRIMARY KEY (AfID),
CONSTRAINT fk_Route FOREIGN KEY (Route) REFERENCES
Route(RtID)
)
INSERT INTO AirFare VALUES(1, 1, 8600, 125);
INSERT INTO AirFare VALUES(2, 2, 5908, 128);

CREATE TABLE Flight_Schedule(
FlID INT,
FlightDate DATETIME,
Departure DATETIME,
Arrival DATETIME,
AirCraft INT,
NetFare INT,
PRIMARY KEY (FlID),
CONSTRAINT fk_AirCraft FOREIGN KEY (AirCraft) REFERENCES
AirCrafts(AcID),
CONSTRAINT fk_NetFare FOREIGN KEY (NetFare) REFERENCES
AirFare(AfID)
)
INSERT INTO Flight_Schedule VALUES(1, 'January 23, 2012', '23:20', '1:20', 1, 1);
INSERT INTO Flight_Schedule VALUES(2, 'December 23, 2020', '07:20', '11:20', 2, 2);

CREATE TABLE Discounts(
DiID INT PRIMARY KEY,
Title Varchar(32),
Amount INT,
Description Varchar (255)
)

INSERT INTO Discounts VALUES(1,'Childrens', 700, 'Discount is provided to all childrens under age of 10.');
INSERT INTO Discounts VALUES(2,'Handicapped', 800, 'Discount is provided to all Handicapped passenger.');

CREATE TABLE Charges(
ChID INT PRIMARY KEY,
Title Varchar(32),
Amount INT,
Description Varchar (255)
)
INSERT INTO Charges VALUES (2,'Urgent Cancellation', 33.33, '33.3% will be charged for cancellation for booking within 11 hrs from flight time');

CREATE TABLE Countries (
CtID INT PRIMARY KEY,
CountryName Varchar (32) NOT NULL
)

INSERT INTO Countries VALUES(1, 'Nepal');
INSERT INTO Countries VALUES(2, 'India');
INSERT INTO Countries VALUES(3, 'USA');
INSERT INTO Countries VALUES(4, 'Germany');



CREATE TABLE State(
StID INT,
StateName Varchar (32),
Country INT,
PRIMARY KEY (StID),
CONSTRAINT fk_Country FOREIGN KEY (Country) REFERENCES
Countries(CtID)
)

INSERT INTO State VALUES(1, 'Bagmati', 1);
INSERT INTO State VALUES(2, 'Janakpur',1);
INSERT INTO State VALUES(3, 'Pokhara', 1);
INSERT INTO State VALUES(4, 'Maharashtra', 2);
INSERT INTO State VALUES(5, 'MadhyaPradesh', 2);
INSERT INTO State VALUES(6, 'Telegana', 2);
INSERT INTO State VALUES(7, 'Alaska', 3);
INSERT INTO State VALUES(8, 'Texas', 3);
INSERT INTO State VALUES(9, 'Arizona', 3);
INSERT INTO State VALUES(10, 'hesse', 4);
INSERT INTO State VALUES(11, 'saarland', 4);
INSERT INTO State VALUES(12, 'humburg', 4);



CREATE TABLE Contact_Details(
CnID INT PRIMARY KEY,
Email Varchar (16) NOT NULL,
Cell Varchar (16) NOT NULL,
Tel Varchar (16),
Street Varchar (64),
State INT NOT NULL,
CONSTRAINT fk_State FOREIGN KEY (State) REFERENCES State(StID)
)
    
INSERT INTO Contact_Details VALUES(1,'hello@shekhr.com', '9851121824', '01-4215384', 'Gandaki Marga', 1);
INSERT INTO Contact_Details VALUES(2,'hello@abckae.com', '9851121435', '01-4245384', 'Gandhi Road', 2);

CREATE TABLE Passengers(
PsID INT PRIMARY KEY,
Name Varchar (32) NOT NULL,
Address Varchar (64) NOT NULL,
Age INT NOT NULL,
Nationality Varchar(16) NOT NULL,
Contacts INT NOT NULL,
CONSTRAINT fk_Contacts FOREIGN KEY (Contacts) REFERENCES
Contact_Details(CnID)
)
ALTER TABLE Passengers
ADD Password VARCHAR(50) ;
INSERT INTO Passengers VALUES(1,'Shekhar Kumar Sharma', 'Sinamanga-39, KTM', 43, 'Nepalese', 1);
INSERT INTO Passengers VALUES(2,'Priti Rajkumar Panjawani', 'Mane Nagar-39, KTM', 23, 'Indian', 2);

CREATE TABLE Branches(
BrID INT PRIMARY KEY,
Center Varchar(16) NOT NULL,
Address Varchar(32) NOT NULL,
State INT,
CONSTRAINT fk_StateOfEmployee FOREIGN KEY (State) REFERENCES
State(StID)
)

INSERT INTO Branches VALUES(1, 'Kathmandu', 'New Road, Kathmandu', 1);
INSERT INTO Branches VALUES(2, 'Pune', 'New Road, Pune', 2);
INSERT INTO Branches VALUES(3, 'Texas', 'New Road, Texas', 3);
INSERT INTO Branches VALUES(4, 'Saarland', 'New Road, Saarland', 4);

CREATE TABLE Admin
(
AdminID INT PRIMARY KEY,
Name Varchar (32) NOT NULL,
Branch INT NOT NULL,
CONSTRAINT fk_Branch FOREIGN KEY (Branch) REFERENCES
Branches(BrID)
)
INSERT INTO Admin VALUES(1, 'NehaRathore' ,1)
INSERT INTO Admin VALUES(2, 'NehaMahalle' , 2)
INSERT INTO Admin VALUES(3, 'Dipali' , 3)
INSERT INTO Admin VALUES(4, 'Preety' , 4)

ALTER TABLE Admin
ADD Password VARCHAR(50) 

CREATE TABLE Transactions(
TsID INT PRIMARY KEY,
BookingDate DATETIME,
DepartureDate DATETIME,
Passenger INT,
Flight INT,
Charges INT,
Discount INT,
CONSTRAINT fk_Passenger FOREIGN KEY (Passenger) REFERENCES
Passengers(PsID),
CONSTRAINT fk_Flight FOREIGN KEY (Flight) REFERENCES
Flight_Schedule(FlID),
CONSTRAINT fk_Charges FOREIGN KEY (Charges) REFERENCES
Charges(ChID),
CONSTRAINT fk_Discount FOREIGN KEY (Discount) REFERENCES
Discounts(DiID)
)
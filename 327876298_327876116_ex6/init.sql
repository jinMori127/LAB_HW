CREATE DATABASE IF NOT EXISTS MyFirstDataBase;
use MyFirstDataBase;
DROP TABLE IF EXISTS Teams;
DROP TABLE IF EXISTS Players;
DROP TABLE IF EXISTS Budget;
DROP TABLE IF EXISTS Houses;

CREATE TABLE Teams
(Num int,
Team varchar(40),
City varchar(40),
Established int,
Coach varchar(40),
Wins int);
INSERT into Teams VALUES 
(1, 'Maccabi', 'Tel-Aviv', 1960, 'Neven Spahija', 12),
(2, 'Hapoel', 'Jerusalem', 1965, 'Dainius Adomaitis', 9),
(3, 'Maccabi', 'Haifa', 1978, 'Amit Ben-David', 6),
(4, 'Hapoel', 'Tel-Aviv', 1957, 'Dani Franko', 8),
(5, 'Hapoel', 'Galil-elion', 1972, 'Barak Peleg', 11);

CREATE TABLE Players
(PlayerID int,
PlayerName varchar(20),
TeamNum int,
Age int);
INSERT into Players VALUES 
(1, 'Gil Benny', 5, 23),
(2, 'Yoval Zossman', 1, 22),
(3, 'Iftach Ziv', 5, 26),
(4, 'Omri Kasspi', 1, 32),
(5, 'Adam Ariel', 2, 27),
(6, 'Tamir Blat', 2, 24),
(7, 'Adi Cohen Saban', 2, 27),
(8, 'Naor Sharon', 3, 26),
(9, 'Rom Gefen', 3, 27),
(10, 'Matan Naor', 4, 31);

CREATE TABLE Budget
(TeamNum int,
Budget int);
INSERT into Budget VALUES 
(1,  3500),
(2,  2100),
(3,  1500),
(4,  2000),
(5, 1700);

CREATE TABLE Houses
(TeamNum int,
House VARCHAR(1));
INSERT into Houses VALUES 
(1,  'B'),
(2,  'A'),
(3,  'A'),
(4,  'B'),
(5, 'A');
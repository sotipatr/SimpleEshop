drop database if exists demoeshop;
create database demoeshop;

use demoeshop;

/*We create our main table where we are performing our data analysis*/

CREATE TABLE OFFERS 
(
    offerid int NOT NULL AUTO_INCREMENT,
    name varchar(50),
    description varchar(255),
    price varchar(50),
    expirationDate DATETIME,
    status varchar(50),
    PRIMARY KEY(offerid)
);


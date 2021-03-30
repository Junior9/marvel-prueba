DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS comics;
DROP TABLE IF EXISTS sincronizaciones;
DROP TABLE IF EXISTS creators;
DROP TABLE IF EXISTS characters_comics;
DROP TABLE IF EXISTS creators_comics; 

CREATE TABLE characters (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  resourceURI VARCHAR(250),
  marvel_Id INT NOT NULL
);

CREATE TABLE comics (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  decription VARCHAR(250),
  marvel_Id INT NOT NULL
);

CREATE TABLE sincronizaciones (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date VARCHAR(250),
  amount_characters INT,
  amount_comics  INT,
  amount_creators INT
);

CREATE TABLE creators (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  full_name VARCHAR(250) ,
  marvel_Id INT NOT NULL
); 

CREATE TABLE characters_comics (
	id INT AUTO_INCREMENT PRIMARY KEY,
    marvel_characters_id INT NOT NULL,
    marvel_comics_id INT NOT NULL
);

CREATE TABLE creators_comics (
	id INT AUTO_INCREMENT PRIMARY KEY,
    marvel_creators_id INT NOT NULL,
    marvel_comics_id INT NOT NULL,
    role_creator  VARCHAR(250) NOT NULL
);
 


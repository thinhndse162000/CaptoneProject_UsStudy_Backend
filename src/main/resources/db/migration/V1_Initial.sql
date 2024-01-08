CREATE DATABASE Capstone_db
GO
USE Capstone_db
GO
CREATE TABLE Role(
    RoleId INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    RoleName VARCHAR(10) NOT NULL
)
GO

CREATE TABLE User(
    UserId INT NOT NULL PRIMARY KEY  IDENTITY(1,1),
    UserName NVARCHAR(255) ,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL ,
    Address  NVARCHAR(255),
    Gender VARCHAR(10),
    RoleId INT NOT NULL UNIQUE
)
GO

CREATE TABLE University(
    UniversityId INT NOT NULL  PRIMARY KEY  IDENTITY(1,1),
    UniversityName NVARCHAR(50) NOT NULL,
    Description NVARCHAR(255),
    Tuition MONEY,
    StudyTime NVARCHAR(50),
    Semester NVARCHAR(50),
    State NVARCHAR(50) NOT NULL
)
GO

CREATE TABLE RegistrationForm(
    StudentProfileId INT NOT NULL UNIQUE ,
    UniversityId INT NOT NULL UNIQUE
)
CREATE TABLE Major(
    MajorId INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    MajorName NVARCHAR(50) NOT NULL,
    Description NVARCHAR(255)
)
GO

CREATE TABLE Program(
    ProgramId INT NOT NULL UNIQUE PRIMARY KEY IDENTITY(1,1),
    Status varchar(10) NOT NULL,
    UniversityId INT NOT NULL UNIQUE,
    CreatedDate DATETIME,
    CreatedTime DATETIME,
    ModifiedDate DATETIME,
    ModifiedTime DATETIME,
    MajorId INT NOT NULL UNIQUE,
    Duration VARCHAR(50),
    Description NVARCHAR(255),
    Tuition Money,
    Level NVARCHAR(50)
)
Go
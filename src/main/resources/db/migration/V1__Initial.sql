CREATE TABLE Customer(
    customer_id INT NOT NULL  PRIMARY KEY  IDENTITY(1,1),
    full_name NVARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL  UNIQUE ,
    [password] VARCHAR(255) NOT NULL,
    [address] NVARCHAR(255) ,
    date_of_birth DATETIME ,
    gender VARCHAR(10),
    phone VARCHAR(50) NOT NULL
)
GO

CREATE TABLE Consultant(
    consultant_id INT NOT NULL  PRIMARY KEY  IDENTITY(1,1),
    username NVARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE ,
    description NVARCHAR(255),
    [password] VARCHAR(255) NOT NULL
)
GO

CREATE TABLE ProgramType(
    program_type_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    type_name NVARCHAR(50),
    description NVARCHAR(255)
)
GO

CREATE TABLE Major(
    major_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    major_name NVARCHAR(50),
    description NVARCHAR(255)
)
GO

CREATE TABLE UniversityType(
    university_type_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    type_name NVARCHAR(50),
    description NVARCHAR(255)
)
GO

CREATE TABLE [State](
    state_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    state_name NVARCHAR(50),
    description NVARCHAR(255)
)
GO

CREATE TABLE Semester(
    semester_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    start_date DATETIME ,
    end_date DATETIME
)
GO

CREATE TABLE University(
    university_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    university_type_id INT NOT NULL ,
    state_id INT NOT NULL ,
    tuition Money,
    description NVARCHAR(255)
)
GO

CREATE TABLE Program(
    program_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    status VARCHAR(10) NOT NULL ,
    create_date DATETIME,
    modified_date DATETIME,
    duration VARCHAR(50),
    description NVARCHAR(255),
    tuition Money,
    university_id INT NOT NULL ,
    major_id INT NOT NULL ,
    semester_id INT NOT NULL ,
    program_type_id INT NOT NULL
)
GO

CREATE TABLE ProgramStage(
    program_stage_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    stage_name NVARCHAR(50),
    program_id INT NOT NULL
)
GO

CREATE TABLE StudentProfile(
    student_profile_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    full_name NVARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL  UNIQUE ,
    date_of_birth DATETIME ,
    gender VARCHAR(10),
    phone VARCHAR(50) NOT NULL,
    [address] NVARCHAR(255) ,
    create_date DATETIME,
    place_of_birth NVARCHAR(50) NOT NULL,
    national_id CHAR(13) NOT NULL,
    study_process NVARCHAR(255) NOT NULL,
    customer_id INT NOT NULL
)
GO

CREATE TABLE UploadFile(
    file_upload_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    file_attach VARCHAR(255),
    student_profile_id INT NOT NULL
)
GO

CREATE TABLE ApplyStage(
    apply_stage_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    student_profile_id INT NOT NULL ,
    program_stage_id INT NOT NULL ,
    update_date DATETIME,
    status NVARCHAR
)
GO

CREATE TABLE RegistrationForm(
    registration_form_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    area NVARCHAR(50) NOT NULL,
    more_information NVARCHAR(255),
    study_abroad_reason NVARCHAR(255) NOT NULL,
    destination_reason NVARCHAR (255) NOT NULL,
    program_choose NVARCHAR(255) NOT NULL,
    major_choose NVARCHAR(255) NOT NULL,
    major_choose_reason NVARCHAR(255) NOT NULL,
    university_choose_reason NVARCHAR(255) NOT NULL,
    priority_of_study_abroad NVARCHAR(255) NOT NULL,
    budget NVARCHAR(255) NOT NULL,
    customer_id INT NOT NULL,
    consultant_id INT
)
GO




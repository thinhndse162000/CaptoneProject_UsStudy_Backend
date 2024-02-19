USE Capstone_db

ALTER TABLE Program
ADD modifier INT;

ALTER TABLE Program
ADD [level] VARCHAR(50);

ALTER TABLE University
ADD university_name VARCHAR(255);
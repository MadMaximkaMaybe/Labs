CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  last_name VARCHAR(100) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  middle_name VARCHAR(100) NOT NULL,
  birthdate DATE NOT NULL,
  student_id VARCHAR(10) NOT NULL
);

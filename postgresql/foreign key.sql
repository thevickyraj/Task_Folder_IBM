CREATE TABLE Course (
    Course_ID INT PRIMARY KEY,
    Course_Name VARCHAR(50),
    StudentID INT,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);

INSERT INTO Student (StudentID, Name, Age)
VALUES
(1, 'Vicky', 22),
(2, 'Rahul', 21),
(3, 'Priya', 20);

INSERT INTO Course (Course_ID, Course_Name, StudentID)
VALUES
(101, 'Java', 1),
(102, 'Python', 2),
(103, 'SQL', 3);

TRUNCATE TABLE Course, Student;

select * from student;
SELECT * FROM course;

alter table student add primary key(studentid);
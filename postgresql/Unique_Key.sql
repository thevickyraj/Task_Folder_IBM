ALTER TABLE Student
ADD COLUMN Email VARCHAR(100);

select * from student;
select * from course;

ALTER TABLE Student
ADD CONSTRAINT unique_email UNIQUE (Email);


INSERT INTO Student (StudentID, Name, Age, Email)
VALUES
(1, 'Vicky', 22, 'vicky@example.com'),
(2, 'Rahul', 21, 'rahul@example.com');

INSERT INTO Student (StudentID, Name, Age, Email)
VALUES
(3, 'Priya', 20, 'vicky@example.com');-- duplicate value


select * from student s 
left join course c ON s.studentId = c.studentid;

select * from student s
right join course c on s.studentId = c.studentId;

SELECT
    s.StudentID,
    s.Name,
    c.Course_Name
FROM Student s
INNER JOIN Course c
ON s.StudentID = c.StudentID;


SELECT * from student s
cross join  course;


SELECT *,
CASE 
  when age < 18 THEN 'Not Eligible'
  when age >= 18 THEN 'Eligible'
END as vote from student;

create INDEX idx_student_id ON student(studentid);

SELECT *
FROM pg_indexes
WHERE tablename = 'student';





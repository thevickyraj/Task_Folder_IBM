ALTER TABLE Student
ADD CONSTRAINT chk_age
CHECK (Age >= 18);

select * from student;

INSERT INTO Student (StudentID, Name, Age)
VALUES (5, 'sahu', 13);
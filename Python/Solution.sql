# Write your MySQL query statement below
SELECT Students.id, Students.name
FROM Students
LEFT JOIN Departments
ON Departments.id = Students.department_id
WHERE Departments.id IS NULL

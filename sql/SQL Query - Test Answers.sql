
-- 1. Retrieve the first 5 employees by highest salary.

SELECT * 
FROM employees
ORDER BY salary DESC
LIMIT 5;

-- 2. Retrieve the 5 employees with the lowest salary, skipping the first 10 records

SELECT * 
FROM employees
ORDER BY salary
LIMIT 5 OFFSET 10;

-- 3. Display each department's total salary, 
 -- but only show departments where the total salary exceeds $30,000.

SELECT 
	d.department_id,
    d.department_name,
    SUM(e.salary) as total_salary
FROM employees e JOIN departments d
ON e.department_id = d.department_id
GROUP BY e.department_id
HAVING total_salary > 30000;

-- 4. For each employee, display their salary and a note if it is above or below $7000.

SELECT
	employee_id,
    CONCAT(first_name, ' ', last_name) AS employee_name,
    salary,
    CASE
		WHEN salary >= 70000 THEN 'Salary above 70000'
        WHEN salary < 70000 THEN 'Salary below 70000'
	END AS note
FROM employees;


-- 5. List the projects that started in the last 6 months

SELECT *
FROM projects
WHERE start_date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH);

-- 6. Display all projects, including those with no employees assigned.

SELECT *
FROM projects p LEFT JOIN
	employee_projects ep ON p.project_id = ep.project_id;
    
-- 7. Increase the salary of all employees in the 'Finance' department by 12%.

UPDATE employees
SET salary = salary + (salary * 1.2)
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'Finance');

-- 8. Retrieve the first and last names of employees whose last names start with 'S'.

SELECT *
FROM employees
WHERE first_name LIKE 'S%';
	
-- 9. Count the number of employees assigned to each department.

SELECT
	d.department_id,
    d.department_name,
	COUNT(e.employee_id) AS no_of_employees
FROM employees e JOIN departments d 
	ON e.department_id = d.department_id
GROUP BY e.department_id;

-- 10. Find the total number of hours worked by employees on each project.

SELECT
    p.project_name,
    SUM(ep.hours_worked) AS total_hrs_worked
FROM
	projects p JOIN employee_projects ep ON p.project_id = ep.project_id
GROUP BY ep.project_id, ep.hours_worked;

-- 11. Select the employees who earn more than the average salary.

SELECT *
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- 12. Display each project's start date in the format 'Month Day, Year' (e.g., January 01, 2024

SELECT 
	project_id, 
    project_name, 
    DATE_FORMAT(start_date, '%M %d, %Y') AS start_date
FROM projects;

-- 13. List all employees, their department names, and the projects they have worked on.

SELECT
	CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
	d.department_name,
    p.project_name
FROM
	employees e JOIN employee_projects ep ON e.employee_id = ep.employee_id
    JOIN projects p ON p.project_id = ep.project_id
    JOIN departments d ON e.department_id = d.department_id;
    
-- 14. List all projects, showing 'Assigned' if any employees are assigned and 'Unassigned' otherwise.

SELECT
	p.project_id,
    p.project_name,
	CASE
		WHEN COUNT(ep.employee_id) > 0 THEN 'Assigned'
        ELSE 'Unassigned'
	END AS status
FROM projects p
	LEFT JOIN employee_projects ep ON ep.project_id = p.project_id
GROUP BY p.project_id, p.project_name;

-- 15. Find the average salary of employees in each department, 
-- but only show departments where more than 5 employees work.

SELECT
	d.department_id,
    d.department_name,
	AVG(e.salary) AS avg_salary
FROM
	employees e JOIN departments d ON e.department_id = d.department_id
GROUP BY department_id
HAVING COUNT(employee_id) >= 2;

-- 16. Concatenate employees' first and last names into a single full name, separated by a space.

SELECT
	CONCAT(first_name, ' ', last_name) AS employee_name
FROM employees;

-- 17. Set all employees with salaries above $8000 and 
-- belonging to the 'IT' department to a new salary of $8500.

UPDATE
	employees e JOIN departments d ON e.department_id = d.department_id
SET e.salary = 8500
WHERE e.salary > 8000
AND d.department_name = 'IT';

-- 18. Find the employee with the highest salary who works in the 'HR' department

SELECT
	e.*
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE 
	d.department_name = 'HR' 
	AND e.salary = (
		SELECT MAX(salary) FROM employees e 
        JOIN departments d ON e.department_id = d.department_id
        WHERE d.department_name = 'HR'
	);

-- 19. Find employees who have been assigned to projects that will end within the next 2 months

SELECT e.*
FROM employees e 
	JOIN employee_projects ep ON e.employee_id = ep.employee_id
    JOIN projects p ON p.project_id = ep.project_id
WHERE
	p.end_date < DATE_ADD(CURDATE(), INTERVAL 2 MONTH);

-- 20. For each project, show the total salary billed based on the hours worked by employees, 
-- but only for projects where total billing exceeds $10,000.

SELECT 
    p.project_id,
    p.project_name,
    SUM(e.salary * ep.hours_worked / 160) AS total_billed_salary 
    -- Considering 160 working hours per month
FROM 
    Projects p
JOIN 
    Employee_Projects ep ON p.project_id = ep.project_id
JOIN 
    Employees e ON ep.employee_id = e.employee_id
GROUP BY 
    p.project_id, p.project_name
HAVING 
    total_billed_salary > 10000;



    
    


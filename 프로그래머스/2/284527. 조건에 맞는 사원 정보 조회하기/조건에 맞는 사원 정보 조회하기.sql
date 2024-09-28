select SUM(SCORE) as score,	b.EMP_NO,	EMP_NAME,	POSITION,	EMAIL
from HR_EMPLOYEES a join hr_grade b
on a.emp_no=b.emp_no 
group by year,emp_no
having year='2022'
order by 1 desc
limit 1
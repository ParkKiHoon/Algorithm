select id,email,first_name,last_name
FROM DEVELOPERS D, SKILLCODES S
where 1=1 and (d.skill_code & s.code)>0 and s.category='front end'
GROUP BY ID, EMAIL, FIRST_NAME, LAST_NAME
order by id
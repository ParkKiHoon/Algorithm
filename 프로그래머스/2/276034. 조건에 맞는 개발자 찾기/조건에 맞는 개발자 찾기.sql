select ID,	EMAIL,	FIRST_NAME,	LAST_NAME
from developers
where SKILL_CODE &(select code from skillcodes where name='Python') or 
SKILL_CODE &(select code from skillcodes where name='C#')

order by ID asc
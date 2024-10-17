select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH,"%Y-%m-%d") as DATE_OF_BIRTH
from member_profile
where month(DATE_OF_BIRTH)=3 and tlno is not null and gender='w'
order by member_id asc
select YEAR(b.SALES_DATE) as YEAR , MONTH(b.SALES_DATE) as MONTH, a.GENDER, COUNT(distinct(a.USER_ID)) as USERS
from USER_INFO a
join ONLINE_SALE b
on a.USER_ID=b.USER_ID
where a.gender is not null
group by YEAR,MONTH,a.GENDER
order by YEAR,MONTH,a.GENDER
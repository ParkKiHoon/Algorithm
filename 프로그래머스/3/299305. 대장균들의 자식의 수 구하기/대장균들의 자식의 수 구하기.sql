select id, ifnull(cnt,0) as CHILD_COUNT
from ecoli_data a left join ( SELECT PARENT_ID, COUNT(PARENT_ID) AS CNT
    FROM ECOLI_DATA
    GROUP BY PARENT_ID) as b
    on a.id=b.parent_id
order by id asc
select id, case 
when SIZE_OF_COLONY<=100 then 'LOW'
when SIZE_OF_COLONY<=1000 and SIZE_OF_COLONY>100 then 'MEDIUM'
when SIZE_OF_COLONY>1000 then 'HIGH' end as SIZE
from ecoli_data
order by id asc
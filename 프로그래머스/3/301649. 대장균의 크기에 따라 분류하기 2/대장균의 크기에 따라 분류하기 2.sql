select a.id, case when a.per<=0.25 then 'CRITICAL'
            when a.per<=0.5 then 'HIGH'
            when a.per<=0.75 then 'MEDIUM'
            when a.per<=1 then 'LOW' end as COLONY_NAME
from (select id, percent_rank() over (order by size_of_colony desc) as per
from ecoli_data) as a
order by id asc
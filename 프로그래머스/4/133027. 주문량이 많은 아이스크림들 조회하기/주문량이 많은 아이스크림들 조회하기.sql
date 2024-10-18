select a.FLAVOR
from FIRST_HALF a
join JULY b
on a.FLAVOR=b.FLAVOR

group by b.flavor
order by sum(a.TOTAL_ORDER)+sum(b.TOTAL_ORDER) desc
limit 3
select a.category, sum(b.sales) as TOTAL_SALES
from BOOK a join book_sales b
on a.book_id=b.book_id 
where b.SALES_DATE like '2022-01%'
group by category
order by category asc
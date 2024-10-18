select a.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY, sum(price*sales) as TOTAL_SALES
from book a join author b
on a.author_id=b.author_id
join BOOK_SALES c
on a.book_id=c.book_id
where SALES_DATE like '2022-01%'
group by a.AUTHOR_ID, a.category 
order by author_id,category desc
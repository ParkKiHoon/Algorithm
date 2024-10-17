select date_format(SALES_DATE,'%Y-%m-%d') as sales_date,	PRODUCT_ID,	USER_ID,	SALES_AMOUNT
from ONLINE_SALE
where SALES_DATE like '2022-03%'

union all

select date_format(SALES_DATE,'%Y-%m-%d') as sales_date,	PRODUCT_ID,	null as USER_ID,	SALES_AMOUNT
from offline_sale
where SALES_DATE like '2022-03%'

order by sales_date, product_id , user_id
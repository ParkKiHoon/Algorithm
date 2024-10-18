select CATEGORY	,PRICE as MAX_PRICE,	PRODUCT_NAME
from food_product
where (category,price) in(
select category, max(price) from FOOD_PRODUCT
                        group by category
                        having category in ('과자', '국', '김치', '식용유'))
                        
order by max_price desc
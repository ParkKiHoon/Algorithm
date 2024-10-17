select a.rest_id, a.rest_name, a.food_type, a.favorites, a.ADDRESS, round(avg(b.review_score),2) as score
from rest_info a join rest_review b
on a.rest_id=b.rest_id
group by a.rest_id
having a.address LIKE "서울%"
order by score desc , a.favorites desc
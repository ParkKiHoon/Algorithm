select a.TITLE,	a.BOARD_ID,	b.REPLY_ID, b.WRITER_ID,	
b.CONTENTS,	date_format(b.CREATED_DATE,'%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD a join USED_GOODS_REPLY b
on a.board_id = b.board_id
where year(a.CREATED_DATE)=2022 and month(a.CREATED_DATE)=10
order by CREATED_DATE asc , a.title asc
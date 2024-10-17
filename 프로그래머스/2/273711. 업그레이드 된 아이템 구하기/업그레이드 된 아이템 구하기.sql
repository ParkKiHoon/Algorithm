select a.ITEM_ID,	ITEM_NAME,	RARITY
from ITEM_INFO a join ITEM_TREE b
on a.item_id = b.item_id
where b.PARENT_ITEM_ID in (select item_id from item_info where rarity='rare')
order by a.item_id desc

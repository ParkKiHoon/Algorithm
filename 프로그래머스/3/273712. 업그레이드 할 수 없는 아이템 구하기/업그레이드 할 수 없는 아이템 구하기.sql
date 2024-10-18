SELECT
    ITEM_ID,
    ITEM_NAME,
    RARITY
FROM
    ITEM_INFO 
    
where item_id not in (select PARENT_ITEM_ID from item_tree where parent_item_id is not null)

order by item_id desc
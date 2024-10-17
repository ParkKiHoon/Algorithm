select count(*) as FISH_COUNT
from FISH_INFO
where FISH_TYPE in (select fish_type
                   from FISH_NAME_INFO
                   where fish_name='bass'
                   or fish_name='snapper')
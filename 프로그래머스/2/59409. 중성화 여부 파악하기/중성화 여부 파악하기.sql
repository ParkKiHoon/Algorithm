select animal_id,name,case when (SEX_UPON_INTAKE LIKE '%NEUTERED%' OR SEX_UPON_INTAKE LIKE '%SPAYED%') then 'O' else 'X' end as 중성화
from animal_ins
order by animal_id asc
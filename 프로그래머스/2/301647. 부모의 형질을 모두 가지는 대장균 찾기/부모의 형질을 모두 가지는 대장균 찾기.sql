select a.id, a.genotype, b.genotype as PARENT_GENOTYPE
from ECOLI_DATA  a join ECOLI_DATA  b
on a.PARENT_ID=b.id
where (a.genotype & b.genotype)=b.genotype
order by a.id asc
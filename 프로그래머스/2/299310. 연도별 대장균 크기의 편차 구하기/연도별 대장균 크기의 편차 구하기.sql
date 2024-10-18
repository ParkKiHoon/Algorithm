select year(DIFFERENTIATION_DATE) as year, (select max(size_of_colony) 
                                   from ecoli_data where year(DIFFERENTIATION_DATE)=year) - SIZE_OF_COLONY as YEAR_DEV, id 
                                   from ECOLI_DATA
                                   order by year asc , year_dev asc
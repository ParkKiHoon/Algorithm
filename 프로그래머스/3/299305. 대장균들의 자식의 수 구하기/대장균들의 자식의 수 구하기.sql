SELECT 
    E.ID,
    COALESCE(COUNT(C.ID), 0) AS CHILD_COUNT
FROM 
    ECOLI_DATA E
LEFT JOIN 
    ECOLI_DATA C
ON 
    E.ID = C.PARENT_ID
GROUP BY 
    E.ID
ORDER BY 
    E.ID;

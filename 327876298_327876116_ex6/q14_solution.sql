SELECT 
    CASE 
        WHEN Team LIKE 'Hapoel%' THEN 'Hapoel'
        WHEN Team LIKE 'Maccabi%' THEN 'Maccabi'
    END AS TeamType,
    COUNT(*) AS TeamCount
FROM Teams GROUP BY TeamType;
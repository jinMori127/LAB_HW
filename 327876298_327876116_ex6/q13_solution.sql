SELECT
    CASE 
        WHEN Team LIKE 'Hapoel%' THEN 'Hapoel'
        WHEN Team LIKE 'Maccabi%' THEN 'Maccabi'
    END AS TeamType,
    SUM(Wins) AS TotalWins
FROM
    Teams
GROUP BY
    TeamType;
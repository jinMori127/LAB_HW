SELECT City, COUNT(City) AS NumberOfTeams
FROM Teams
GROUP BY City
HAVING COUNT(*) > 1;
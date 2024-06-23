SELECT house.House, P.PlayerName
FROM Houses house
JOIN Players P ON house.TeamNum = P.TeamNum
ORDER BY house.House ASC, P.PlayerName ASC;

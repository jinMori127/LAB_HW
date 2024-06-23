SELECT team.Num , team.Team, team.City, COUNT(P.PlayerID) AS NumberOfPlayers
FROM Teams team
LEFT JOIN Players P ON team.Num = P.TeamNum
GROUP BY team.Num, team.Team, team.City
ORDER BY team.Num ASC;

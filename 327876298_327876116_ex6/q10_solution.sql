SELECT house.House, Teams.Num AS TeamNum, Teams.Team, Teams.City
FROM Houses house
JOIN Teams ON house.TeamNum = Teams.Num
ORDER BY house.House ASC, Teams.Num asc;

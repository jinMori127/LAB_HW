SELECT house.House
FROM Players P
JOIN Houses house ON P.TeamNum = house.TeamNum
WHERE P.PlayerName = 'Adam Ariel';
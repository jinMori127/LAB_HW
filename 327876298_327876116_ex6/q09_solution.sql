Select Teams.Team, Teams.City, Teams.Wins , Budget.Budget 
from Teams 
join Budget on Budget.TeamNum = Teams.Num
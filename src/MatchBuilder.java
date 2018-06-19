public class MatchBuilder
{
	private Match match;

	private MatchBuilder() {
		match = new Match();
	}
	
	public static MatchBuilder create() {
		return new MatchBuilder();
	}

	public MatchBuilder withTeams(String hometeam, String awayteam) {
		match.setTeamHome(homeTeam);
		match.setTeamAway(awayTeam);
		return this;
	}

	public withScore(int homeTeamPoints, int awayTeamPoints) {
		match.setScoreHomeTeam(homeTeamPoints);
		match.setScoreAwayTeam(awayTeamPoints);
		return this;
	}

	public Match build() {
		return match;
	}
}

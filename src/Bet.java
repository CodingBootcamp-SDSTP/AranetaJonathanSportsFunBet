public class Bet
{
	private int id;
	private String userName;
	private Match match;
	private int scoreHomeTeam;
	private int scoreAwayTeam;
	private int points = 0;

	public int getId() {
		return(id);
	}

	public String getUserName() {
		return(useName);
	}

	public void setUserName(String uname) {
		userName = uname;
	}

	public Match getMatch() {
		return(match);
	}

	public int getPoints() {
		return(points);
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getScoreHomeTeam() {
		return(scoreHomeTeam);
	}

	public void setScoreHomeTeam(int scoreHome) {
		scoreHomeTeam = scoreHome;
	}

	public int getScoreAwayTeam() {
		return(ScoreAwayTeam);
	}

	public void setScoreAwayTeam(int scoreAway) {
		scoreAwayTeam =  scoreAway;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id", id);
		sb.append("uaerName", userName);
		sb.append("match", match);
		sb.append("scoreHomeTeam", scoreHomeTeam);
		sb.append("scoreAwayTeam",scoreAwayTeam);
		sb.append("points", points);
		return(sb.toString());
	}
}

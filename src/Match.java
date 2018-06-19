import java.time.LocalDateTime;

public class Match
{
	private int id;
	private String homeTeam;
	private String awayTeam;
	private int scoreHomeTeam;
	private int scoreAwayTeam;
	private LocalDateTime gameDate;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return(id);
	}

	public void setHomeTeam(String home) {
		homeTeam = home;
	}

	public int getHomeTeam() {
		return(homeTeam);
	}

	public void setAwayTeam(String away) {
		awayTeam = away;
	}

	public int getAwayTeam() {
		return(awayTeam);
	}

	public void setscoreHomeTeam(String scoreHome) {
		scoreHomeTeam = scoreHome;
	}

	public int getscoreHomeTeam() {
		return(scoreHomeTeam);
	}

	public void setscoreAwayTeam(String scoreAway) {
		scoreAwayTeam = scoreAway;
	}

	public int getscoreAwayTeam() {
		return(scoreAwayTeam);
	}
	public boolean hasResultSet() {
		return(scoreHomeTeam !=null && scoreAwayTeam != null);
	}

	public boolean hasStarted() {
		return(LocalDateTime.now().isAfter(gameDate);
	}

	public void enterResult(int scoreHomeTeam, int scoreAwayTeam) {
		this.scoreHomeTeam = scoreHomeTeam;
		this.scoreAwayTeam = scoreAwayTeam;
	}

	public int getPointsDifference() {
		return(Math.abs(scoreHomeTeam - scoreAwayTeam);
	}

	public boolean isHomeTeamWinner() {
		return(scoreHomeTeam > scoreAwayTeam);
	}

	public boolean isAwayTeamWinner() {
		return(scoreAwayTeam > scoreHomeTeam);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder() {
			sb.append("id", id);
			sb.append("homeTeam",homeTeam);
			sb.append("awayTeam",awayTeam);
			sb.append("scoreAwayTeam",scoreAwayTeam);
			sb.append("scoreHomeTeam",scoreHomeTeam);
			sb.append("gameDate",gameDate);
			return(sb.toString());
		}
	}
}

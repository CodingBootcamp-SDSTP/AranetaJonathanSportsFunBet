import java.util.ArrayList;

public class TeamList
{
	private ArrayList<BasketballTeam> teams;

	public TeamList() {
		teams = new ArrayList<BasketballTeam>();
	}

	public void addTeam(BasketballTeam team) {
		teams.add(team);
	}

	public void removeTeam(BasketballTeam team) {
		teams.remove(team);
	}

	public ArrayList<BasketballTeam> getAllTeams() {
		return(teams);
	}

	public BasketballTeam getTeamByIndex(int n) {
		return(teams.get(n));
	}

	public int getBasketballTeamCount() {
		return(teams.size());
	}

	public ArrayList<BasketballTeam> search(String s) {
		BasketballTeam b = null;
		ArrayList<BasketballTeam> bt = new ArrayList<BasketballTeam>();
		String str = s.toLowerCase();
		for(int i=0; i<getBasketballTeamCount(); i++) {
			b = getTeamByIndex(i);
			if(matches(b, str)) {
				bt.add(b);
			}
		}
		return(bt);
	}

	public boolean matches(BasketballTeam b, String str) {
		String name = b.getName().toLowerCase();
		String location = b.getLocation();
		if(location.contains(str) || name.contains(str)) {
			return(true);
		}
		return(false);
	}
}

import java.util.ArrayList;

class BasketballTeam
{
	String name;
	String location;
	ArrayList<Player> players;

	public BasketballTeam(String n, String l, ArrayList<Player> players) {
		name = n;
		location = l;
		this.players = players;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return(name);
	}

	public void setLocation(String loc) {
		location = loc;
	}

	public String getLocation() {
		return(location);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}
}

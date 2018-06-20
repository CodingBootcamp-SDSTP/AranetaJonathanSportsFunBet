import java.util.ArrayList;

class PlayerList
{
	ArrayList<Player> players;

	public PlayerList() {
		players = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public ArrayList<Player> getAllPlayers() {
		return(players);
	}

	public Player getPlayerByIndex(int n) {
		return(players.get(n));
	}

	public int getPlayerCount() {
		return(players.size());
	}

	public Player getPlayerById(int id) {
		Player player = null;
		for(int i=0; i<getPlayerCount(); i++) {
			if(getPlayerByIndex(i).getId() == id) {
				player = getPlayerByIndex(i);
			}
		}
		return(player);
	}

	public ArrayList<Player> search(String s) {
		Player p = null;
		ArrayList<Player> pl = new ArrayList<Player>();
		String str = s.toLowerCase();
		for(int i=0; i<getPlayerCount(); i++) {
			p = getPlayerByIndex(i);
			if(matches(p, str)) {
				pl.add(p);
			}
		}
		return(pl);
	}

	public boolean matches(Player p, String str) {
		int id = p.getId();
		String name = p.getName().toLowerCase();
		int age = p.getAge();
		int height = p.getHeight();
		int weight = p.getWeight();
		String position = p.getPosition();
		String i = Integer.toString(id);
		String a = Integer.toString(age);
		String h = Integer.toString(height);
		String w = Integer.toString(weight);
		if(i.contains(str) || name.contains(str) || a.contains(str) || h.contains(str) || w.contains(str) || position.contains(str)) {
			return(true);
		}
		return(false);
	}
}

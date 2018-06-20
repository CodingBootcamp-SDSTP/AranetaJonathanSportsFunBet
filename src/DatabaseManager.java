import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.*;

public class DatabaseManager
{
	private TeamList teams;
	private PlayerList players;
	Connection conn;

	public DatabaseManager() {
		teams = new TeamList();
		players = new PlayerList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myprojectdb?user=myproject&password=myproject&serverTimezone=UTC&useSSL=false");
			readFromDB(conn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addTeam(BasketballTeam team) {
		teams.addTeam(team);
	}

	boolean insertToDB(BasketballTeam team, Player player) {
		PreparedStatement stmt = null;
		try {
				stmt = conn.prepareStatement("INSERT INTO team ( name, location) VALUES ( ?, ?, ?" );
				stmt.setString(1, team.getName());
				stmt.setString(2, team.getLocation());
				stmt.setString(3, "teams");
				//stmt.executeUpdate();

				stmt = conn.prepareStatement("INSERT INTO players ( playerID, name, age, height, weight, position, team) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?" );
				stmt.setInt(1, player.getId());
				stmt.setString(2, player.getName());
				stmt.setInt(3, player.getAge());
				stmt.setInt(4, player.getHeight());
				stmt.setInt(5, player.getWeight());
				stmt.setString(6, player.getPosition());
				stmt.setString(7, player.getTeam());
				stmt.setString(8, "players");
				stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public TeamList getTeamList() {
		return(teams);
	}

	public PlayerList getPlayerList() {
		return(players);
	}

	public Player getPlayerById(int id) {
		return(players.getPlayerById(id));
	}

	public ArrayList<Object> search(String s) {
		ArrayList<Object> ao = new ArrayList<Object>();
		ArrayList<Player> p = players.search(s);
		ArrayList<BasketballTeam> b = teams.search(s);
		ao.addAll(p);
		ao.addAll(b);
		return(ao);
	}

	public boolean readFromDB(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean v = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM teams;");
			while(rs.next()) {
				String[] str = {
					rs.getString("name"),
					rs.getString("location"),
					"teams"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM players;");
			while(rs.next()) {
				String[] str = {
					rs.getString("playerID"),
					rs.getString("name"),
					rs.getString("age"),
					rs.getString("height"),
					rs.getString("weight"),
					rs.getString("position"),
					rs.getString("team"),
					"players"
				};
				createObject(str);
			}
			v = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) {stmt = null;}} catch(Exception e) {};
			try { if(rs != null) {rs = null;}} catch(Exception e) {};
		}
		return(v);
	}

	public void createObject(String... details) {
		int len = details.length - 1;
		String d = details[len];
		if("players".equals(d)) {
			Player p = new Player(Integer.parseInt(details[0]), details[1],Integer.parseInt(details[2]), Integer.parseInt(details[3]), Integer.parseInt(details[4]), details[5], details[6]);
			players.addPlayer(p);
		}
		else if("teams".equals(d)) {
			BasketballTeam b = new BasketballTeam(details[0], details[1]);
			teams.addTeam(b);
		}
	}

	public String getCollectionContent() {
		ArrayList<Player> p = players.getAllPlayers();
		ArrayList<BasketballTeam> b = teams.getAllTeams();
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<p.size(); i++) {
			Player player = p.get(i);
			sb.append(player.getDetails() + "\n");
		}

		for(int i=0; i<b.size(); i++) {
			BasketballTeam team = b.get(i);
			sb.append(team.getDetails());
			if(i < b.size()-1) {
				sb.append("\n");
			}
		}
		return(sb.toString());
	}
}

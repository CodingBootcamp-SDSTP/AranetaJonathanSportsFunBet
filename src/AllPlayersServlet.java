import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AllPlayersServlet extends HttpServlet
{
	DatabaseManager dbm;
	PlayerList pl;

	public void init() throws ServletException {
		dbm = new DatabaseManager();
		pl = dbm.getPlayerList();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		out.print(exportToXML());
		System.out.println(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<players>");
		ArrayList<Player> players = pl.getAllPlayers();
		for(Player p : players) {
			printPlayer(sb, p);
		}
		sb.append("</players>");
		return(sb.toString());
	}

	public String printPlayer(StringBuilder sb, Player p) {
		sb.append("<player>");
		sb.append("<playerId>" + p.getId() + "</playerId>");
		sb.append("<name>" + p.getName() + "</name>");
		sb.append("<age>" + p.getAge() + "</age>");
		sb.append("<height>" + p.getHeight() + "</height>");
		sb.append("<weight>" + p.getWeight() + "</weight>");
		sb.append("<position>" + p.getPosition() + "</position>");
		sb.append("<team>" + p.getTeam() + "</team>");
		sb.append("</player>");
		return(sb.toString());
	}

	public void destroy() {
		dbm = null;
		pl = null;
	}
}

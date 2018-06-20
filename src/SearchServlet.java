import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SearchServlet extends HttpServlet
{
	DatabaseManager dbm;
	TeamList tl;
	PlayerList pl;
	//AllTeamsServlet ats;
	AllPlayersServlet aps;
	PrintWriter out;

	public void init() throws ServletException {
		dbm = new DatabaseManager();
		tl = dbm.getTeamList();
		pl = dbm.getPlayerList();
		//ats = new AllTeamsServlet();
		aps = new AllPlayersServlet();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		if(req.getParameter("text") != null) {
			out.print(searchToXML(req.getParameter("text")));
		}
	}

	public String searchToXML(String value) {
		ArrayList<Object> objects = dbm.search(value);
		StringBuilder sb = new StringBuilder("<objects>");
		for(Object o : objects) {
			printObject(sb, o);
		}
		sb.append("</objects>");
		return(sb.toString());
	}

	public String printObject(StringBuilder sb, Object o) {
		// if(o instanceof BasketballTeam) {
		// 	BasketballTeam b = (BasketballTeam)o;
		// 	ats.printTeam(sb, b);
		// }
		if(o instanceof Player) {
			Player p = (Player)o;
			aps.printPlayer(sb, p);
		}
		return(sb.toString());
	}

	public void destroy() {
		dbm = null;
		tl = null;
		pl = null;
		//ats = null;
		aps = null;
	}
}

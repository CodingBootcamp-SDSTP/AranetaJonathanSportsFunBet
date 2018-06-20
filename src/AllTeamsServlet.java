import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AllTeamsServlet extends HttpServlet
{
	DatabaseManager dbm;
	TeamList tl;

	public void init() throws ServletException {
		dbm = new DatabaseManager();
		tl = dbm.getTeamList();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		out.print(exportToXML());
		System.out.println(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<teams>");
		ArrayList<BasketballTeam> teams = tl.getAllTeams();
		for(BasketballTeam b : teams) {
			printTeam(sb, b);
		}
		sb.append("</teams>");
		return(sb.toString());
	}

	public String printTeam(StringBuilder sb, BasketballTeam b) {
		sb.append("<team>");
		sb.append("<name>" + b.getName() + "</name>");
		sb.append("<location>" + b.getLocation() + "</location>");
		sb.append("</team>");
		return(sb.toString());
	}

	public void destroy() {
		dbm = null;
		tl = null;
	}
}

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class AddTeamServlet extends HttpServlet
{
	DatabaseManager dbm;

	public void init() throws ServletException {
		dbm = new DatabaseManager();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("POST request from nodejs na may tamang value");
		InputStreamReader isr = new InputStreamReader(req.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		String[] details = line.split("&");
		String[] name = details[0].split("=");
		String[] location = details[1].split("=");
		BasketballTeam team = new BasketballTeam(name[0], location[1]);
		dbm.addTeam(team);
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		out.close();
	}

	public void destroy() {
		dbm = null;
	}
}

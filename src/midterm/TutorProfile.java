package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import requests.GuestBookEntry;

/**
 * Servlet implementation class TutorProfile
 */
@WebServlet("/midterm/TutorProfile")
public class TutorProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ArrayList<Tutor> tutors = new ArrayList<Tutor>();
		tutors.add(new Tutor("john","doe","john@doe.com","math"));
		tutors.add(new Tutor("mary","jane","mary@jane.com","english"));
		tutors.add(new Tutor("andre","pierre","andre@pierre.com","french"));
	
		
		ServletContext context = this.getServletContext();
		context.setAttribute("tutors", tutors);
	}  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set the content type
		response.setContentType("text/html");

		// Get a reference to the PrintWriter that lets us talk to the client
		PrintWriter out = response.getWriter();

		// Generate the HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println(
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("    <meta charset=\"UTF-8\">");

		/* Page Title goes here */
		out.println("    <title>Tutor Profiles</title>");
		out.println("</head>");
		//body starts
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<div class=\"page-header\">");
		out.println("    <h1>Tutor Information<small> Profile</small></h1>");
		out.println("</div>");
		String s = request.getParameter("query");
		out.println("<form class=\"form-inline\" action=\"TutorProfile\" method=\"get\">");
		out.println("	<div class=\"form-group\">");
		out.println(
				"		<input class=\"form-control\" type=\"text\" name=\"query\" value=\"\" placeholder=\"Enter your search term(s) \">");
		out.println("		<input class=\"form-control btn btn-primary\" type=\"submit\" value=\"Search\">");
		out.println("	</div>");
		out.println("</form>");

		out.println("<hr>");
		//table begins
		
		out.println("<table class=\"table table-bordered table-striped table-hover\">");
		out.println("<tr>");
		out.println("  <th>Name</th><th>Email</th><th>Course Taught</th>");
		out.println("</tr>");
		
		
		ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
		
		for (Tutor tutor:tutors) {
			
			if (s == null || s.equals("") ||s.equalsIgnoreCase(tutor.getTeach())|| s.equalsIgnoreCase(tutor.getFullName())
					|| s.equalsIgnoreCase(tutor.getEmail())) {
				out.println("<tr>");
				out.println("  <td>" + tutor.getFullName() + "</td>");
				out.println("  <td>" + tutor.getEmail() + "</td>");
				out.println("  <td>" + tutor.getTeach() + "</td>");

				
				
			}

		}
		out.println("</table>");

		out.println("<a class=\"btn btn-primary\" href=\"Register\">Register</a>");
		out.println("<a class=\"btn btn-primary\" href=\"TutorAdmin\">Admin site</a>");

		out.println("</div>");
		out.println("</body>");

		out.println("</html>");

			
		}
		
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

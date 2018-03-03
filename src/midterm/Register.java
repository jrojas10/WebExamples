package midterm;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class RegisterSessions
 */

@WebServlet("/midterm/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		// Set the content type
		response.setContentType("text/html");
		
		// Get a reference to the PrintWriter that lets us talk to the client
		PrintWriter out = response.getWriter();
		
		// Generate the HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("    <meta charset=\"UTF-8\">");
		
		/* Page Title goes here */
		out.println("    <title>Register</title>");
		out.println("</head>");
		
		/* Page Body goes here */
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<div class=\"page-header\">");
		out.println("    <h1>Register <small>Tutors</small></h1>");
		out.println("</div>");
		
		// Create the login form
		out.println("<form action=\"Register\" method=\"post\">");
		
		
		
		
		
		
		String nameError = (String) request.getAttribute("nameError");		
		if (nameError != null) {
			out.println("	<div class=\"form-group has-error\">");	
			out.println("		<span class=\"help-block\">" + nameError + "</span>");
		}
		else
			out.println("	<div class=\"form-group\">");	
		
		String name = request.getParameter("name");
		name = name == null ? "" : name;
		
		out.println("		<label class=\"control-label\">Full Name</label>");
		out.println("		<input class=\"form-control\"type=\"text\" value=\"" + name + "\" name=\"name\" placeholder=\"First Name\">");
		out.println("	</div>");
		
		
		
		
		
		
		String nameError2 = (String) request.getAttribute("nameError");		
		if (nameError2 != null) {
			out.println("	<div class=\"form-group has-error\">");	
			out.println("		<span class=\"help-block\">" + nameError2 + "</span>");
		}
		else
			out.println("	<div class=\"form-group\">");	
		
		String name2 = request.getParameter("name");
		name2 = name2 == null ? "" : name2;
		
		out.println("		<label class=\"control-label\">Full Name</label>");
		out.println("		<input class=\"form-control\"type=\"text\" value=\"" + name2+ "\" name=\"name2\" placeholder=\"Last Name\">");
		out.println("	</div>");	
		
		
		
		
		
		
		
		String usernameError = (String) request.getAttribute("usernameError");		
		if (usernameError != null) {
			out.println("	<div class=\"form-group has-error\">");	
			out.println("		<span class=\"help-block\">" + usernameError + "</span>");
		}
		else
			out.println("	<div class=\"form-group\">");	
		
		String username = request.getParameter("username");
		username = username == null ? "" : username;
		
		out.println("		<label class=\"control-label\">Username (E-mail Address)</label>");
		out.println("		<input class=\"form-control\"type=\"text\" value=\"" + username + "\" name=\"username\" placeholder=\"Email\">");
		out.println("	</div>");
		
		
		
		String teachError = (String) request.getAttribute("teachError");		
		if (teachError != null) {
			out.println("	<div class=\"form-group has-error\">");	
			out.println("		<span class=\"help-block\">" + teachError + "</span>");
		}
		else
			out.println("	<div class=\"form-group\">");	
		
		String teach = request.getParameter("teach");
		teach = teach == null ? "" : teach;
		
		out.println("		<label class=\"control-label\">Course Taught</label>");
		out.println("		<input class=\"form-control\"type=\"text\" value=\"" + teach + "\" name=\"teach\" placeholder=\"Course Taught\">");
		out.println("	</div>");
		
		
		out.println("	<button type=\"submit\" class=\"btn btn-primary\">Register</button>");
		out.println("</form>");		
		out.println("</div>");
		out.println("</body>");
		
		out.println("</html>");
	}



	boolean usernameInUse(String username) {
		
		ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
		for(Tutor tutor : tutors) {
			
			if (tutor.getEmail().toLowerCase().matches(username.toLowerCase()))
				return true;
		}
		return false;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String name2 = request.getParameter("name2");
		String username = request.getParameter("username");
		String teach = request.getParameter("teach");
		
		
		
		
		boolean hasError = false;
		
		
		if (teach== null || teach.trim().length()==0) {
			request.setAttribute("teachError", "You must specify a course");
			hasError = true;
		}
		
		if(name2==null ||name2.trim().length()==0) {
			request.setAttribute("nameError2", "Enter name correctly");
			hasError= true;
		}
		
		
	if(name==null ||name.trim().length()==0) {
		request.setAttribute("nameError", "Enter name correctly");
		hasError= true;
	}
		
		
		// Validate the username
		if (username == null || username.trim().length() == 0) {
			request.setAttribute("usernameError", "You must specify a Username");
			hasError = true;
		}
else if (usernameInUse(username)) {
		request.setAttribute("usernameError", "That username is already in use.");
		hasError = true;
}
		
		
		
		
			
		if (hasError) {
			doGet(request, response);
			return;
		}
		else {
			ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
			Tutor newTutor = new Tutor(name,name2, username, teach);
			tutors.add(newTutor);			
			response.sendRedirect("TutorProfile");
			return;
		}
	}

}












package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Student;

/**
 * Servlet implementation class RegisterSessions
 */
@WebServlet("/sessions/Register")
public class RegisterSessions extends HttpServlet {
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
		out.println("    <h1>Register <small>HttpSessions</small></h1>");
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
		out.println("		<input class=\"form-control\"type=\"text\" value=\"" + name + "\" name=\"name\" placeholder=\"First and Last Names\">");
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
		
		
		
		String passwordError = (String) request.getAttribute("passwordError");		
		if (passwordError != null) {
			out.println("	<div class=\"form-group has-error\">");			
			out.println("		<span class=\"help-block\">" + passwordError + "</span>");
		}
		else {
			out.println("	<div class=\"form-group\">");
		}
		
		String password1 = request.getParameter("password1");
		password1 = password1 == null ? "" : password1;
		out.println("		<label class=\"control-label\">Password</label>");
		out.println("		<input class=\"form-control\"type=\"password\" value=\"" + password1 + "\" name=\"password1\" placeholder=\"Password\">");
		
		String password2 = request.getParameter("password2");
		password2 = password2 == null ? "" : password2;
		out.println("		<label class=\"control-label\">Re-Enter Password</label>");
		out.println("		<input class=\"form-control\"type=\"password\" value=\"" + password2 + "\" name=\"password2\" placeholder=\"Re-Enter Password\">");
		out.println("	</div>");
		
		out.println("	<button type=\"submit\" class=\"btn btn-primary\">Register</button>");
		out.println("</form>");		
		out.println("</div>");
		out.println("</body>");
		
		out.println("</html>");
	}


	boolean usernameInUse(String username) {
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		for(Student student : students) {
			if (student.getEmail().toLowerCase().matches(username.toLowerCase()))
				return true;
		}
		return false;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullName = request.getParameter("name");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		String first = null, last = null;
		
		boolean hasError = false;
		
		// Validate the name
		if (fullName == null || !fullName.matches("[a-zA-Z]{2,} [a-zA-Z]{2,}")) {
			request.setAttribute("nameError", "You must enter your full name");
			hasError = true;
		}
		else {
			String[] names = fullName.split(" +");
			first = names[0];
			last = names[1];
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
		
		// Validate the password
		if (password1 == null || password1.trim().length() == 0) {
			request.setAttribute("passwordError", "You must specify a password");
			hasError = true;
		}
		else if (password2 == null || !password1.equals(password2)) {
			request.setAttribute("passwordError", "Passwords don't match.");
			hasError = true;
		}
			
		if (hasError) {
			doGet(request, response);
			return;
		}
		else {
			ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
			Student newStudent = new Student(first, last, username, password1);
			students.add(newStudent);
			
			HttpSession session = request.getSession();
			session.setAttribute("authenticatedStudent", newStudent);
			
			response.sendRedirect("MyProfile");
			
		}
	}

}











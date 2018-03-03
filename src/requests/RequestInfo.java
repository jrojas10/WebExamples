package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		out.println("<link rel=\"stylesheet\" href=\"https://bootswatch.com/united/bootstrap.min.css\">");
		/* Page Title goes here */
		out.println("    <title>Request Parameters</title>");

		out.print("<header class=\"text-center\">");
		out.print("<div class=\"jumbotron\">");
		out.print(" <h1>Request Parameters <small>Lab 2</small></h2>");
		out.print("</div class=\"jumbotron\">");
		out.print("</header>");

		out.println("</head>");

		/* Page Body goes here */
		out.println("<h3 class =\"text-center\">The following <code>" +request.getMethod()+ "</code> request was made on <code>" + new java.util.Date() + " </code></h3>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		// table 1

		out.println("<table class=\"table table-bordered table-hover table-striped\">");

		out.println("	<tr class>");
		out.println("		<th>Parameter Name</th>");
		out.println("		<th>Parameter Value</th>");
		out.println("	</tr>");

		@SuppressWarnings("rawtypes")
		Enumeration nameOf = request.getParameterNames();
		String name;
		// String test = (String) nameOf.nextElement();
		while (nameOf.hasMoreElements()) {
			name = (String) nameOf.nextElement();
			String array[] = request.getParameterValues(name);
			out.println("	<tr>");
			out.println("		<td>" + name + "</td>");
			out.println("		<td><span class = \"label label-info\"> " + Arrays.toString(array) + " </span></td>");
			out.println("	</tr>");

		}

		out.print("</table>");

		// table 2

		out.println("<table class=\"table table-bordered table-hover table-striped\">");
		out.println("	<tr class=\"text-center\">");
		out.println("		<th>Header Field</th>");
		out.println("		<th>Header Value</th>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td>Server Name</td>");
		out.println("		<td>" + request.getServerName() + "</td>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td>URL</td>");
		out.println("		<td>" + request.getRequestURL() + "</td>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td>Request Method</td>");
		out.println("		<td>" + request.getMethod() + "</td>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td>Request URI</td>");
		out.println("		<td>" + request.getRequestURI() + "</td>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td>Context Path</td>");
		out.println("		<td>" + request.getContextPath() + "</td>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td>Remote (Your) Address</td>");
		out.println("		<td>" + request.getRemoteAddr() + "</td>");
		out.println("	</tr>");

		out.print("		</tr>");
		@SuppressWarnings("rawtypes")
		Enumeration headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.print("<tr>");
			out.print("	<td>" + headerName + "</td>");
			String headerValue = request.getHeader(headerName);
			out.println("<td> " + headerValue + "</td>");
			out.print("</tr>");
		}

		// body ends

		out.println("</div>");
		out.println("</body>");

		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
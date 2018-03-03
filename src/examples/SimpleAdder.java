package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/SimpleAdder")
public class SimpleAdder extends HttpServlet {
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

		/* Page Title goes here */
		out.println("    <title>Request Information</title>");
		out.print("<h1>Request Information <small> Lab 2</small></h1>\r\n" + "");
		out.println("</head>");

		/* Page Body goes here */
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<div class=\"page-header\">");
		out.println("    <h1>Simple Adder Servlet <small>HttpServletRequest</small></h1>");
		out.println("</div>");

		out.println("<table class=\"table table-bordered table-hover table-striped\">");

		out.println("	<tr class =\"text-center\">");
		out.println("		<th>Parameter Name</th>");
		out.println("		<th>Parameter Value</th>");
		out.println("	</tr>");

		@SuppressWarnings("rawtypes")
		Enumeration nameOf = request.getParameterNames();
		String name;
		String value;
		// String test = (String) nameOf.nextElement();
		while (nameOf.hasMoreElements()) {
			name = (String) nameOf.nextElement();
			String array[] = request.getParameterValues(name);
			value = (String) request.getParameter(name);
		
			out.println("	<tr>");
			out.println("		<td>" + name + "</td>");
			out.println("		<td><span class = \"label label-info\"> " + Arrays.toString(array) + " </span></td>");
			out.println("	</tr>");

		}
		
		out.print("</table>");

		// String a[] = request.getParameterValues(test);
		// out.print(Arrays.toString(a));

		out.println("</div>");
		out.println("</body>");

		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}

package sessions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sessions/Logout")

public class LogoutSessions extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie ("student",null);
		cookie.setMaxAge(0);
		cookie.setPath("/cs3220stu31");
		response.addCookie(cookie);
		request.getSession().invalidate();
	
		response.sendRedirect("Login");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

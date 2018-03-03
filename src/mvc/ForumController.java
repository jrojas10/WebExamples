package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import models.Post;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ForumController
 */
@WebServlet("/ForumController")
public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForumController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Post> posts = new ArrayList<Post>();
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu31";
			String username = "cs3220stu31";
			String password = "LU!XDd.q";
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from web");
			while (rs.next()) {
				Post p = new Post(rs.getInt("id"),rs.getString("title"), rs.getInt("upvote"), rs.getInt("downvote"), rs.getString("link"));
				posts.add(p);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		finally {
			 try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
		}
		request.setAttribute("posts", posts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ForumView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

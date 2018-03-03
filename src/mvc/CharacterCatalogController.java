package mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Simpson;

@WebServlet(urlPatterns ="/CharacterCatalog",loadOnStartup = 1)
public class CharacterCatalogController extends HttpServlet{
	private static final long serialVersionUID = 1L;
   
   
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	

    	  ArrayList<Simpson>simpsons = new ArrayList<Simpson>();
    	String line;
    	String[] fields;
    	String name;
    	int number;
    	try {
		//	BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Juan\\Desktop\\characters.csv")));
    		ServletContext servletContext = getServletContext();
    		InputStream is = servletContext.getResourceAsStream("/WEB-INF/characters.csv");
    		//String fullPath = servletContext.getRealPath("/WEB-INF/charactersN.csv");

    		
//    		BufferedReader br = new BufferedReader(new FileReader(new File(fullPath)));
    		BufferedReader br = new BufferedReader(new InputStreamReader(is));
			line = br.readLine();
			while((line=br.readLine())!=null) {
		
				fields = line.split(",");
				name = fields[0];
				 number = (int) Integer.parseInt(fields[1]);
				 Simpson simpson = new Simpson();
				 	simpson.setName(name);
				 	simpson.setNumber(number);
				simpsons.add(simpson);
				
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    
        getServletContext().setAttribute("simpsons", simpsons);
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CharacterCatalog.jsp");
	dispatcher.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
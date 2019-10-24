package Com.ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class welcome
 */
@WebServlet("/welcome")
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();

		try
		{
			
			String name=request.getParameter("user_name");
			out.println("Url Rewriting User: "+name);
			
//			String username=request.getParameter("username");
//			out.println("<h2> Welcome : "+username+"</h2>");
			
		/*	ServletConfig sc=getServletConfig();
			out.println(sc.getInitParameter("email"));
			ServletContext sc1=getServletContext();
			out.println(sc1.getInitParameter("driverName")); */
			
			//response.sendRedirect("http://www.studytonight.com");
			
			HttpSession sesson=request.getSession();
			String username1=(String)sesson.getAttribute("username1");
			out.println("Session User, Hello : "+username1);
			
			Cookie[] cks=request.getCookies();
//			out.println("Cookie User, Hello : "+cks[0].getValue());
			out.println("Cookie User, Hello : "+name);
			
		}
		finally
		{
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
}

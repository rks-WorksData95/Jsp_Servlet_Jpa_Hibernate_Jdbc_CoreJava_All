package Com.ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out=response.getWriter();
		try
		{
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(username.equals("RamSadhu") && password.equals("ramsadhu"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username1", username);
				
				Cookie ck=new Cookie("username2", username);
				response.addCookie(ck);
				response.sendRedirect("welcome?user_name="+username+"");
				//RequestDispatcher rd=request.getRequestDispatcher("welcome");
				//rd.forward(request, response);
			}
			else
			{
				out.println("<font color='red'><b>You are enterd incorrect password.</b></font>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		}
		finally
		{
			
			out.close();
			
		}
		
		
	}

}

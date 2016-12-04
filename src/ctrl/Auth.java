package ctrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//doPost(request,response);
	
			
			
	
		if (request.getParameter("logout") !=null){
			request.getSession().removeAttribute("Authorized");
			response.sendRedirect("/FoodsRUs/Admin");

		}
		else if(request.getParameter("browse") !=null){
			response.sendRedirect("/FoodsRUs/eFoods");
			}
		else {
		if(request.getSession().getAttribute("Authorized") == null){
			
			String q = request.getQueryString();
			String user = q.substring(q.indexOf("=")+1, q.indexOf("&"));
			String firstname = q.substring(q.indexOf("name=")+5, q.indexOf("+"));
			String lastname = q.substring(q.indexOf("+")+1, q.length());

		
			System.out.println(q);
			System.out.println(user);
			System.out.println(firstname);
			System.out.println(lastname);

			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("name", firstname+ " "+lastname);
			request.getSession().setAttribute("Authorized", "Success");
		}
			this.getServletContext().getRequestDispatcher("/Account.jsp").forward(request, response);
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

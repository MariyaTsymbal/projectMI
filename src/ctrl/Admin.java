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
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//doPost(request,response);
	/*
		if (request.getSession().getAttribute("Authorized") != null)
	{
		
		if (request.getParameter("logout") !=null){
			request.getSession().removeAttribute("Authorized");
			request.getSession().invalidate();
			this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

		}
		else if(request.getParameter("browse") !=null){
			this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		}
		else {
		this.getServletContext().getRequestDispatcher("/Account.jsp").forward(request, response);
		}
	}
	else
	{
	*/
		if (request.getParameter("login") != null)
		{
			String back= "http://localhost:4413/FoodsRUs/Auth";
			String username=request.getParameter("name");
			String password=request.getParameter("pass");
			System.out.println(username+ " pass:"+password);
			
			String hash = "";
			try
			{
				hash = javax.xml.bind.DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA1").digest(password.getBytes()));
			} catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			
			response.sendRedirect("https://"+username+":"+password+"@www.eecs.yorku.ca/~ivona95/auth/Auth.cgi?back="+back);
			
			
			Cookie[] c = request.getCookies();
			
			//if(q.indexOf("user=")>0){
			//username =q.substring(q.indexOf("user="));
			//}
			System.out.println(response.getHeader("user"));
			System.out.println("What is back? "+back);
			System.out.println("What is username? "+username);
			System.out.println(c[0].getName()+ " "+ c[0].getVersion());
			String q= request.getQueryString();
			System.out.println(q);
			System.out.println("OMG redirects work! :O");
			
			
				
				//if(request.authenticate(response)){
				//}
				
				
				
		}
		else {
			this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
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

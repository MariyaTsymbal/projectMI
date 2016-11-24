package ctrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
						
		if (request.getSession().getAttribute("Authorized") != null){
			this.getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);
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
		
		
		if (request.getParameter("login") != null)
		{
			
				String hash = "emptyHash";
				//try
				//{
					//hash = javax.xml.bind.DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA1").digest((request.getParameter("pass")).getBytes()));
					hash = request.getParameter("pass");
					System.out.print(hash);
			//	} catch (NoSuchAlgorithmException e)
			//	{
			//		e.printStackTrace();
			//	}
				
				String realPath = request.getServletContext().getRealPath("/WEB-INF/passwords");
				
				BufferedReader file = new BufferedReader(new FileReader(realPath));
				
				String line = file.readLine();
				
				while (line != null)
				{
					String[] split = line.split(" ");
					String login = split[0];
					String password = split[1];
					
					if (login.equals(request.getParameter("name")) && password.equals(hash))
					{
						request.getSession().setAttribute("Authorized", "Success");
						break;
					}	
					line = file.readLine();
				}
				
		}
		
		if (request.getSession().getAttribute("Authorized") != null)
		{
			this.getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);
		}
		else
		{
			this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			
		}
	
	}

}

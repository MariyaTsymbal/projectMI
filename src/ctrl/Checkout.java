package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * onclick checkout, come here
		 * if not logged in, go to login
		 * else if cart is empty go to browse
		 * else create PO file
		 * and output HTML with order
		 */
		if(request.getParameter("checkout") !=null){
			if(request.getSession().getAttribute("Authorized") ==null){
				response.sendRedirect(this.getServletContext().getContextPath() + "/Admin");
			}
			else if(request.getSession().getAttribute("test") == null){
				response.sendRedirect(this.getServletContext().getContextPath() + "/Add");
			}
			else {
				request.getSession().setAttribute("checkout", "possible");
				int poNum=(int) request.getServletContext().getAttribute("poNum");
				String fileName = request.getSession().getAttribute("user").toString()+"_"+poNum;
				
			
			}
		}
		else {
			this.getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);

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

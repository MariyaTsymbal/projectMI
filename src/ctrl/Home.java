package ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryBean;
import model.CategoryDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/eFoods")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{response.setContentType("text/plain");
		
		CategoryDAO cd = new CategoryDAO();
		System.out.println("1");
		ArrayList<CategoryBean> categories = (ArrayList<CategoryBean>)cd.getCategories();
		System.out.println("2");
		//System.out.print("Number of categories: "+categories.size());
		request.setAttribute("categories", categories);
		
		
		
		this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println("Shit happened");
		}
		
		/*if(request.getParameter("checkout") != null && request.getAttribute("Authorized").equals(true)){
		this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		
		}

		this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);*/

		//this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

		/* start on home.jsp
		 * if Foods R Us clicked, go to home.jsp
		 * if sign in clicked, go to login.jsp
		 * 		-->authentication
		 * if checkout clicked, go to Cart.jsp
		 * 		--> fill many of the attributes in; from catalogue
		 * if browse clicked, go to catalogue.jsp
		 * 		--> have categories for each of the options
		 * 		-->list items with picture
		 * 
		 */
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

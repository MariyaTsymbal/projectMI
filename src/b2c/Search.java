package b2c;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemBean;
import model.ItemDao;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Search/");
		if(request.getParameter("searchBar") != null)
		{
			String toSearch = request.getParameter("searchBar");
			try
			{
				ItemDao id = new ItemDao();
				ArrayList<ItemBean> items = (ArrayList<ItemBean>)id.getItems();
				for(int i=0; i<items.size();i++)
				{
					if(toSearch.equals(items.get(i).getNumber()))
					{
						System.out.println("Search/found item searched for");
						ItemBean toReturn = items.get(i);
						request.setAttribute("searchResult", toReturn );
					}
					else{
						request.setAttribute("searchResult", "The item with number "+toSearch+" you are looking for doesn't exist" );
					}
										
				}
				
			} catch (Exception e)
			{
				System.out.println("Search/some error happen");
			}
			
			
		}
		this.getServletContext().getRequestDispatcher("/Searchout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package b2c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemBean;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Bitch you for it");
	
		ArrayList<ItemBean> items = null;
		items = (ArrayList<ItemBean>) request.getAttribute("items");
		try{
		System.out.println("Size of toAdd "+ items.isEmpty());}
		catch(Exception e){System.out.println("Fuck you");}
		
		for(int i=0;i<items.size();i++)
		{
		  String number = items.get(i).getNumber();
		  String checkNull = request.getParameter(number);
		  if(checkNull != null)
				 System.out.println("Finally was added");
		}
		
		this.getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);
		System.out.println("Checkc param: " + request.getParameter("2910h019"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

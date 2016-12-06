package b2c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemBean;
import model.ItemDao;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	ArrayList<CartItem> itemList = new ArrayList<CartItem>();
	ArrayList<Long> time = new ArrayList<Long>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Date date = new Date();
		time.add(date.getTime());
		request.getSession().setAttribute("cartaverage", time);
		System.out.println("Add/ time is "+date.getTime());
		

		ArrayList<ItemBean> items = null;
		ItemDao getItems = null;
		try
		{
			getItems = new ItemDao();
			items = getItems.getItems();
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			System.out.println("Size of toAdd " + items.size());
		} catch (Exception e)
		{
			
		}
		// Enumeration<String> enumer =request.getParameterNames();
		int qty=0;
		for(int i=0; i<items.size();i++){
		if (request.getParameter(items.get(i).getNumber()) !=null || request.getParameter("update") != null){
			qty=Integer.parseInt(request.getParameter("qty"));
			
			CartItem c = new CartItem(items.get(i).getNumber(),items.get(i).getName(), items.get(i).getPrice(), qty);
			if(c.getQty()==0){
				itemList.remove(c);
			}
			else{
			for(int k=0; k<itemList.size(); k++){
				if(itemList.get(k).getNumber().equals(c.getNumber())){
					
					itemList.remove(k);
				
				}
				
			}
			
			itemList.add(c);
			}
			
		}
		}
		/*
		Map<String, String[]> params = request.getParameterMap();
		for (int i = 0; i < items.size(); i++)
		{
			String number = items.get(i).getNumber();
			String checkNull = request.getParameter(number);
			if (checkNull != null)
			{
				System.out.println("Add/Is added to cart: " + number);
				ItemBean added = getItems.getItemBean(number);
				System.out.println("Add/Item to add,number:"+number);
				String name = added.getName();
				System.out.println("Add/Item to add,name:" +name);
				double price = added.getPrice();
				System.out.println("Add/Item to add,price:"+price);
				CartItem addToCart =  new CartItem(number, name, price);
				System.out.println("Add/ "+addToCart.toString());
				try{bla.add(addToCart);}
				catch(Exception e)
				{
					System.out.println("Add/SHit happened");
				}
				
		*/
			
				

			

		request.getSession().setAttribute("test", itemList);
		
		
		
		
		System.out.println("Add/Number of items in a cart: "+ itemList.size() );

		this.getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);
		//System.out.println("Checkc param: " + request.getParameter("2910h019"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

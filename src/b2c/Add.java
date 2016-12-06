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
import model.Model;

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
		

		
		Model m = null;

		try
		{
			m = new Model();
		} catch (Exception e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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

		// Enumeration<String> enumer =request.getParameterNames();
		int qty = 0;
		for (int i = 0; i < items.size(); i++)
		{
			if (request.getParameter(items.get(i).getNumber()) != null || request.getParameter("Update") != null)
			{

				qty = Integer.parseInt(request.getParameter("qty"));
				System.out.println(request.getParameter("qty"));
				System.out.println(qty);
				CartItem c = new CartItem(items.get(i).getNumber(), items.get(i).getName(), items.get(i).getPrice(),
						qty);

				if (c.getQty() == 0)
				{
					itemList.remove(c);
				} else
				{
					for (int k = 0; k < itemList.size(); k++)
					{
						if (itemList.get(k).getNumber().equals(c.getNumber()))
						{

							itemList.remove(k);

						}

					}

					itemList.add(c);
				}

			}
		}

		request.getSession().setAttribute("test", itemList);
		String hst = request.getServletContext().getInitParameter("HST");
		String itemTotal = m.itemTotal(itemList);
		String cartTotal = m.cartTotal(itemTotal, hst);
		String taxes = m.taxesApplied(itemTotal, hst);
		String itemCount = m.totalItems(itemList);

		request.getSession().setAttribute("itemCount", itemCount);
		request.getSession().setAttribute("PriceTotal", itemTotal);
		if (Double.parseDouble(itemTotal) > 100)
		{
			request.getSession().setAttribute("PriceTotalInt", Double.parseDouble(itemTotal));
		} else
		{
			request.getSession().removeAttribute("PriceTotalInt");
		}
		request.getSession().setAttribute("TaxApplied", taxes);

		request.getSession().setAttribute("Sum", cartTotal);

		// System.out.println("Add/Number of items in a cart: "+ itemList.size()
		// );

		this.getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);
		// System.out.println("Checkc param: " +
		// request.getParameter("2910h019"));

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

package b2c;

import java.util.ArrayList;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

import model.ItemBean;

/**
 * Application Lifecycle Listener implementation class Cart
 *
 */
@WebListener
public class AddToCart implements ServletRequestAttributeListener
{

	/**
	 * Default constructor.
	 */
	public AddToCart()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
	 */
	public void attributeRemoved(ServletRequestAttributeEvent srae)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
	 */
	public void attributeAdded(ServletRequestAttributeEvent srae)
	{
		// TODO Auto-generated method stub
		ArrayList<ItemBean> items = (ArrayList<ItemBean>) srae.getServletRequest().getAttribute("items");
		ArrayList<String> added = new ArrayList<String>();
		System.out.println("Listener number of items= " + items.size());
		System.out.println("Listener, number of item " + srae.getName());
		for (int i = 0; i < items.size(); i++)
		{
			if (srae.getName().equals(items.get(i).getNumber()))
			{
				added.add(items.get(i).getName());
				System.out.println("Item added: " + items.get(i).getName());
			}
		}
		System.out.println("Cart, added items: " + added.size());

	}

	/**
	 * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
	 */
	public void attributeReplaced(ServletRequestAttributeEvent srae)
	{
		// TODO Auto-generated method stub
	}

}

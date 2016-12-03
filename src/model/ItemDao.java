package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ItemDao
{
	private DataSource dataSource;

	public ItemDao() throws Exception
	{
		try
		{
			this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e)
		{
			System.out.println("Error while calling CategoryDao constructor");
			e.printStackTrace();
		}

	}

	public ArrayList<ItemBean> getItems() throws Exception
	{
		ArrayList<ItemBean> items = new ArrayList<ItemBean>();
		Connection connection = (Connection) dataSource.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("select * from ROUMANI.Item");
		ResultSet result = statement.getResultSet();

		while (result.next())
		{
			// public ItemBean(String number, String name, double price, int
			// qty, int catId)
			try
			{
				ItemBean ib = new ItemBean(result.getString("NUMBER"), result.getString("NAME"),
						result.getDouble("PRICE"), result.getInt("QTY"), result.getInt("CATID"));
				items.add(ib);
				// System.out.println(ib.toString());
			} catch (Exception e)
			{
				System.out.println("Exception was cought in the while loop of ItemDao");
			}

		}
		result.close();
		statement.getConnection().close();
		statement.close();
		System.out.println("Number of items: " + items.size());
		return items;

	}

	public ItemBean getItemBean(String number)
	{ArrayList<ItemBean> items=null;
		try
		{
			items =getItems();
		} catch (Exception e)
		{
			System.out.println("ItemDao/couldn't get items");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<items.size();i++)
		{
			ItemBean item = items.get(i);
			if(item.getNumber().equals(number)) return item;
			
		}
		return null;
		
	}
}

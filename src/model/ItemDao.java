package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ItemDao 
{
	private DataSource dataSource;

	public ItemDao()throws Exception
	{
		try{
			this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/Item");
		}
		catch(NamingException e)
		{
			System.out.println("Error while calling CategoryDao constructor");
			e.printStackTrace();
		}
		
	}
	
	public ItemBean getItem(String number,String name, double price, int qty, int onOrder,int reOrder, int catId, int supId, double costPrice, String unit) throws Exception
	{
		Connection connection = (Connection) dataSource.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("select * from Item");
		ResultSet result = statement.getResultSet();
		
		ItemBean mb = null;
		
		if(result.next()!=false)
		{
			mb = new ItemBean(number,name,price,qty,onOrder,reOrder,catId,supId,costPrice,unit);
		}
		result.close();
		statement.getConnection().close();
		statement.close();
		
		return mb;
		
	}
}

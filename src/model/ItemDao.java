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
	
	public ArrayList<ItemBean> getItems() throws Exception
	{
		ArrayList<ItemBean> items = new ArrayList<ItemBean>();
		Connection connection = (Connection) dataSource.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("select * from ROUMANI.Item");
		ResultSet result = statement.getResultSet();
		
	
		
		if(result.next())
		{
			//ItemBean ib = new ItemBean(result.get);
		}
		result.close();
		statement.getConnection().close();
		statement.close();
		
		return items;
		
	}
}

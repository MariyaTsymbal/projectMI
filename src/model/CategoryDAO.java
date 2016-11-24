package model;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.sql.Blob;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO
{
private DataSource dataSource;

	
	public CategoryDAO() throws Exception
	{
		try{
			this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
			
		}
		catch(NamingException e)
		{
			System.out.println("Error while calling CategoryDao constructor");
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<CategoryBean> getCategories() throws Exception
	{
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		
		Connection connection = (Connection) dataSource.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("select * from ROUMANI.Category order by name");
		ResultSet result = statement.getResultSet();
		
		System.out.println("Result set before if");
		
		while(result.next())
		{
			System.out.println("Result set:");
			CategoryBean nb = new CategoryBean(result.getInt("ID"),new String(result.getString("NAME")), new String(result.getString("DESCRIPTION")));
			System.out.println(nb.toString());
			try{list.add(nb);} catch(Exception e)
			{
				System.out.println("Cought exception while adding bean to linked list");
			}
		}
		result.close();
		statement.getConnection().close();
		statement.close();
		
		return list;
		
	}
	
	
}

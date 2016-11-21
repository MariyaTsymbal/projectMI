package model;

import java.sql.Statement;
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
			this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/Category");
			//this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/Item");
		}
		catch(NamingException e)
		{
			System.out.println("Error while calling CategoryDao constructor");
			e.printStackTrace();
		}
		
	}
	
	public CategoryBean getCategory(int id, String name, String description, Blob image) throws Exception
	{
		Connection connection = (Connection) dataSource.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("select * from Category");
		ResultSet result = statement.getResultSet();
		
		CategoryBean mb = null;
		
		if(result.next()!=false)
		{
			mb = new CategoryBean(id,name,description,image);
		}
		result.close();
		statement.getConnection().close();
		statement.close();
		
		return mb;
		
	}
	
	
}

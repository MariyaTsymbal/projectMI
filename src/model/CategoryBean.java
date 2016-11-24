package model;

import java.sql.Blob;

public class CategoryBean
{
	private int id;
	private String name;
	private String description;
	private Blob image;
	
	public CategoryBean(int id, String name, String description)
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.image = image;
	}
	@Override
	public String toString()
	{
		//return "CategoryBean [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + "]";
		return "CategoryBean [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Blob getImage()
	{
		return image;
	}
	public void setImage(Blob image)
	{
		this.image = image;
	}

}

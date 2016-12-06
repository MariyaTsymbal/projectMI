package b2c;

public class CartItem
{
	@Override
	public String toString()
	{
		return "CartItem [number=" + number + ", name=" + name + ", price=" + price + "]";
	}


	String number;
	String name;
	double price;
	

	public CartItem(String number, String name, double price)
	{
		super();
		this.number = number;
		this.name = name;
		this.price = price;
	}


	public String getNumber()
	{
		return number;
	}


	public String getName()
	{
		return name;
	}


	public double getPrice()
	{
		return price;
	}


	
}

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
	int qty;
	

	public CartItem(String number, String name, double price,int qty)
	{
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.qty=qty;
	}


	public int getQty()
	{
		return qty;
	}


	public void setQty(int qty)
	{
		this.qty = qty;
	}


	public void setNumber(String number)
	{
		this.number = number;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public void setPrice(double price)
	{
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

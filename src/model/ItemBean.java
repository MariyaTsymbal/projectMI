package model;

public class ItemBean
{
	private String number;
	private String name;
	private double price;
	private int qty;
	private int onOrder;
	private int reOrder;
	private int catId;
	private int supId;
	private double costPrice;
	private String unit;
	
	//public ItemBean(String number, String name, double price, int qty, int onOrder, int reOrder, int catId, int supId,
			//double costPrice, String unit)
	public ItemBean(String number, String name, double price, int qty, int catId)
	{
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.qty = qty;
		//this.onOrder = onOrder;
		//this.reOrder = reOrder;
		this.catId = catId;
		//this.supId = supId;
		//this.costPrice = costPrice;
		//this.unit = unit;
	}
	@Override
	public String toString()
	{
		return "ItemBean [number=" + number + ", name=" + name +", price="+price+ ", qty=" + qty + ", catId=" + catId +"]";
		/*return "ItemBean [number=" + number + ", name=" + name + ", price=" + price + ", qty=" + qty + ", onOrder="
				+ onOrder + ", reOrder=" + reOrder + ", catId=" + catId + ", supId=" + supId + ", costPrice="
				+ costPrice + ", unit=" + unit + "]";
		*/
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getQty()
	{
		return qty;
	}
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	public int getOnOrder()
	{
		return onOrder;
	}
	public void setOnOrder(int onOrder)
	{
		this.onOrder = onOrder;
	}
	public int getReOrder()
	{
		return reOrder;
	}
	public void setReOrder(int reOrder)
	{
		this.reOrder = reOrder;
	}
	public int getCatId()
	{
		return catId;
	}
	public void setCatId(int catId)
	{
		this.catId = catId;
	}
	public int getSupId()
	{
		return supId;
	}
	public void setSupId(int supId)
	{
		this.supId = supId;
	}
	public double getCostPrice()
	{
		return costPrice;
	}
	public void setCostPrice(double costPrice)
	{
		this.costPrice = costPrice;
	}
	public String getUnit()
	{
		return unit;
	}
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	 
	

}

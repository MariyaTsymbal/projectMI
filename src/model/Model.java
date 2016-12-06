package model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Model
{
	CategoryDAO categoryData;
	ItemDao itemData;
	
	public Model() throws Exception {
		categoryData=new CategoryDAO();
		itemData = new ItemDao();
		
		File dir = new File("res/POs");
	}
	public String addToCart(List<ItemBean> c, String taxRate, String Shipping){
		double hst=Double.parseDouble(taxRate);
		double ship=Double.parseDouble(Shipping);
		double total=0;
		double itemTotal=0;
		for (int i=0; i<c.size(); i++){
			itemTotal+=c.get(i).getPrice();
		}
		
		total=itemTotal*hst+ship;
		
		return "item: "+ itemTotal+ "HST: "+hst+"Shipping: "+ship+"Total: "+ total;
		
		
				
	}
}

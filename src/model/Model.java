package model;

import java.io.File;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import b2c.CartItem;

public class Model
{
	CategoryDAO categoryData;
	ItemDao itemData;
	
	public Model() throws Exception {
		categoryData=new CategoryDAO();
		itemData = new ItemDao();
		
		File dir = new File("res/POs");
	}
	public String totalItems(List<CartItem> c){
		int count=0;
		for(int i=0;i<c.size();i++){
			count+=c.get(i).getQty();
		}
		return ""+count;
	}
	public String itemTotal(List<CartItem> c){
		double total = 0.0;
		for(int i=0;i<c.size();i++){
			total+=c.get(i).getPrice()*c.get(i).getQty();
		}
		DecimalFormat f = new DecimalFormat("#.##");
		
		return f.format(total);
	}
	public String taxesApplied(String itemTotal, String taxRate){
		double tax= Double.parseDouble(taxRate);
		double item=Double.parseDouble(itemTotal);
		double t=0.0;
		if(item>100){
			t=(item+5)*(tax/100);
		}
		else{
			t=item*(tax/100);
		}
		DecimalFormat f = new DecimalFormat("#.##");
		return f.format(t);
	}
	public String cartTotal(String itemTotal, String taxRate){
		double ship=0.0;
		double item=Double.parseDouble(itemTotal);
		double total = 0.0;
		if(item>100){
			total=item+Double.parseDouble(taxesApplied(itemTotal, taxRate));
		}
		else{
			ship=5.0;
			total=(item+ship)+Double.parseDouble(taxesApplied(itemTotal, taxRate));
		}
		DecimalFormat f = new DecimalFormat("#.##");
		return f.format(total);						
	}
	
}

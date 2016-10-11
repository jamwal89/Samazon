package unittest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import customtools.DBOrders;
import model.Samazonorder;

public class unittest {

	@Test
	public void test() {
		
			List<Samazonorder> order = DBOrders.getProductList();
			float price =0;
			for( int totalitems=0; totalitems<order.size();totalitems ++ ) {
				
				float totalprice= (float) order.get(totalitems).getSamazonproduct().getProductprice();
				 price += totalprice;	
			
			}
			 System.out.println("the total price is "+price);
	     
	}
}

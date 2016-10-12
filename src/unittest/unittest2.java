package unittest;

import static org.junit.Assert.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;

import customtools.DBOrders;
import model.Samazonorder;
import model.Samazonuser;

public class unittest2 {

	@Test
	public void test() {
//		//HttpSession session = request.getSession();
//		
//		List<Samazonorder> orders=DBOrders.getProductList();
//
//		if (!orders.isEmpty()) {
//
//			for ( Samazonorder s : orders){
//				
//				System.out.println(s.getOrderconfirmed());
//				s.setOrderconfirmed("Y");
//				DBOrders.update(s);
//				System.out.println(s.getOrderconfirmed());
//				System.out.println("Order confirmed");	
//					}
//				}
//		else {
//			System.out.println("There are no items in the order list");
//		}

		long userid=1;
		System.out.println("I am here");
		List<Samazonorder> history=DBOrders.getProductHistory(userid);
		System.out.println("I am here 2");
		
		if (!history.isEmpty()) {
		for( Samazonorder or : history) {
			System.out.println("I am here 3");
			System.out.println(or.getOrderid());
			System.out.println(or.getSamazonproduct().getProductname());
			System.out.println(or.getSamazonuser().getUsername());
			
		}
		}
		else {
			System.out.println("list is empty");
		}
			
			
		}
		
		
	
}

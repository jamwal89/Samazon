

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customtools.DBOrders;
import customtools.DBProduct;
import model.Samazonorder;
import model.Samazonproduct;
import model.Samazonuser;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Date date= new Date();
		String action = request.getParameter("action");
		String nextURL="/Products.jsp";
		
		
		if (action.equals("Add")){
			Samazonorder order= new Samazonorder();
			String id=request.getParameter("Productid");
			Samazonproduct prod= DBProduct.getProduct(Long.parseLong(id));
			
			order.setSamazonproduct(prod);
			order.setSamazonuser((Samazonuser) session.getAttribute("user"));
			order.setOrderconfirmed("N");
			order.setOndate(date);
			DBOrders.insert(order);
			
			
			
		}
		else if (action.equals("Delete")){
			System.out.println("I am here");
			String id=request.getParameter("Productid");
			System.out.print("Product is: "+id);
			Samazonorder prod= DBOrders.getProduct(Long.parseLong(id));
			DBOrders.delete(prod);
			 nextURL="/Cart.jsp";
			
		}
		
		
		List<Samazonorder> orders=null;
		orders=DBOrders.getProductList();
		session.setAttribute("orders", orders);
		
		float price =0;
		for( int totalitems=0; totalitems<orders.size();totalitems ++ ) {
			
			float totalprice= (float) orders.get(totalitems).getSamazonproduct().getProductprice();
			 price += totalprice;	
		
		}
		 System.out.println("the total price is "+price);
		 session.setAttribute("price", price);
	
		response.sendRedirect(request.getContextPath() + nextURL);
}
}



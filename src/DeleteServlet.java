

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customtools.DBOrders;
import model.Samazonorder;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		doGet(request, response);
		HttpSession session = request.getSession();
		String nextURL;
		String action = request.getParameter("action");
		
		if (action.equals("Delete")){
			System.out.println("I am here");
			String id=request.getParameter("Productid");
			System.out.print("Product is: "+id);
			Samazonorder prod= DBOrders.getProduct(Long.parseLong(id));
			DBOrders.delete(prod);		
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
		
		 nextURL="/Cart.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
}

	}



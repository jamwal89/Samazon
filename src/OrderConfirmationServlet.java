

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customtools.DBOrders;
import model.Samazonorder;
import model.Samazonuser;

/**
 * Servlet implementation class OrderConfirmationServlet
 */
@WebServlet("/OrderConfirmationServlet")
public class OrderConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderConfirmationServlet() {
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
		@SuppressWarnings("unchecked")
		List<Samazonorder> orders= (List<Samazonorder>) session.getAttribute("orders");
		 
		if (!orders.isEmpty()) {
			
			for ( Samazonorder s : orders){
				System.out.println(s.getOrderconfirmed());
				s.setOrderconfirmed("Y");
				DBOrders.update(s);
				System.out.println(s.getOrderconfirmed());
				System.out.println("Order confirmed");

			}
		}
		else {
			System.out.println("There are no items in the order list");
		}
		
		
		Samazonuser user=(Samazonuser) session.getAttribute("user");
		long userid=user.getUserid();
		List<Samazonorder> history=DBOrders.getProductHistory(userid);
		session.setAttribute("history",history);
		
		String nextURL="/MailServlet" ;
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}

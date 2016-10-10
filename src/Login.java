

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import model.Samazonproduct;
import model.Samazonuser;
import customtools.DBCustomers;
import customtools.DBProduct;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String username = request.getParameter("name");
		@SuppressWarnings("unused")
		String password = request.getParameter("password");
		
		Samazonuser user=DBCustomers.getUserByName(username);
		session.setAttribute("user", user);
		
		List<Samazonproduct> prods=null;
		prods=DBProduct.getProductList();
		session.setAttribute("prods" , prods);
		String nextURL="/Products.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}

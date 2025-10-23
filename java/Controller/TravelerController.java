package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TravelerDao;
import model.Traveler;

/**
 * Servlet implementation class TravelerController
 */
@WebServlet("/Traveler")
public class TravelerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TravelerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("register")) {

			Traveler t = new Traveler();
			t.setName(request.getParameter("name"));
			t.setEmail(request.getParameter("email"));
			t.setPassword(request.getParameter("password"));
			t.setContact(Long.parseLong(request.getParameter("contact")));
			t.setPayment(request.getParameter("payment"));
			System.out.println(t);

			boolean flag = TravelerDao.checkEmail(request.getParameter("email"));
			if (flag == false) {

				TravelerDao.insertowner(t);
				response.sendRedirect("traveler-login.jsp");
			} else {

				request.setAttribute("msg", "E mail already exist");
				request.getRequestDispatcher("traveler-login.jsp").forward(request, response);
			}

		} else if (action.equalsIgnoreCase("login")) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Traveler t = TravelerDao.travelerlogin(email, password);
			
			if(t!=null) {
				
				   HttpSession session = request.getSession();
				   session.setAttribute("data", t);
				   response.sendRedirect("traveler-home.jsp");
			} else {
				
				request.setAttribute("msg", "E mail or password is incorrect");
				request.getRequestDispatcher("traveler-login.jsp").forward(request, response);
			}

		}

	}

}

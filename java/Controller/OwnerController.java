package Controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OwnerDao;
import model.Owner;

/**
 * Servlet implementation class OwnerController
 */
@WebServlet("/Owner")
public class OwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public OwnerController() {
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

			Owner o = new Owner();

			o.setName(request.getParameter("name"));
			o.setEmail(request.getParameter("email"));
			o.setPassword(request.getParameter("password"));
			o.setContact(Long.parseLong(request.getParameter("contact")));
			System.out.println(o);

			boolean flag = OwnerDao.checkEmail(request.getParameter("email"));
			if (flag == false) {

				OwnerDao.insertowner(o);
				response.sendRedirect("owner-login.jsp");

			} else {

				request.setAttribute("msg", "E mail already exist");
				request.getRequestDispatcher("owner-login.jsp").forward(request, response);

			}

		} else if (action.equalsIgnoreCase("login")) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			System.out.println("Login attempt with email: " + email + " and password: " + password);

			Owner o = OwnerDao.ownerlogin(email, password);

			if (o != null) {

				HttpSession session = request.getSession();
				session.setAttribute("data", o);
				System.out.println("Owner data set in session: " + o.getName());
				request.getRequestDispatcher("owner-home.jsp").forward(request, response);

			} else {

				request.setAttribute("msg", "E mail or password is incorrect");
				request.getRequestDispatcher("owner-login.jsp").forward(request, response);

			}
		}
	}
}

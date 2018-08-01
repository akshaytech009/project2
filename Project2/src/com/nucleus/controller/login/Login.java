package com.nucleus.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import com.nucleus.dao.UserReg;
import com.nucleus.dao.UserRegImpl;
import com.nucleus.model.Customer;
import com.nucleus.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SessionFactory sf = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sf = (SessionFactory) getServletContext()
				.getAttribute("sessionfactory");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		String role = null;
		UserReg userreg = new UserRegImpl(sf);
		boolean b = userreg.validate(userid, userpass, role);

		if (b) {
			HttpSession hs = request.getSession();

			hs.setAttribute("userid", userid);
			RequestDispatcher rd = request
					.getRequestDispatcher("WEB-INF/jsp/maker.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("msg1", "Invalid User");
			RequestDispatcher rd = request
					.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rd.forward(request, response);

		}

	}

}

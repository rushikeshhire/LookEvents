package com.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login1
 */
@WebServlet("/login1")
public class UserLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		if (UserLoginDao.validate(Email, Password)) {
			/* RequestDispatche */ rd = request.getRequestDispatcher("main.html");
			rd.forward(request, response);
			// request.getSession().setAttribute("Email", Email);
			// request.getSession().setAttribute("Password", Password);
		} else {
			out.print("Email and Password is incorrect");
			/* RequestDispatcher */ rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		out.close();
	}
}

package com.jwt.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.dao.RegistrationDAO;

public class RegistrationControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int accno=Integer.parseInt(request.getParameter("accno"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password1");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String accounttype = request.getParameter("accounttype");
		int balance=Integer.parseInt(request.getParameter("balance"));

		HttpSession session = request.getSession(true);
		try {
			RegistrationDAO userDAO = new RegistrationDAO();
			userDAO.addUserDetails(accno,userName, password, email, phone, city,accounttype,balance);
			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
			response.sendRedirect("Failure");
		}

	}
}

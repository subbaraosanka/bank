package com.jwt.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.dao.BalanceDAO;

public class BalanceControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int accno=Integer.parseInt(request.getParameter("accno"));
		String type = request.getParameter("type");
		int amount=Integer.parseInt(request.getParameter("amount"));

		HttpSession session = request.getSession(true);
		try {
			BalanceDAO marksDAO = new BalanceDAO();
			marksDAO.addMarksDetails(accno,type,amount);
			request.setAttribute("amount",amount);
			request.getRequestDispatcher("DepositeCal.jsp").forward(request, response); 
			//response.setParameter("amount");
			//response.sendRedirect("DepositeCal.jsp");
		} catch (Exception e) {

			e.printStackTrace();
			response.sendRedirect("Failure");
		}

	}
}

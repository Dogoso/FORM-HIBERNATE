package com.doglab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.doglab.dao.UserDAO;
import com.doglab.users.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class Index extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("iptPassword");
		String url = "http://localhost:8080/FORM-JSP-SERVLET/index.jsp?msg=created";
		if(password.length() < 7) {
			url = "http://localhost:8080/FORM-JSP-SERVLET/index.jsp?msg=password";
		}else {
			User user = new User();
			user.setName(request.getParameter("iptName"));
			user.setSurname(request.getParameter("iptSurname"));
			user.setEmail(request.getParameter("iptEmail"));
			user.setAdress(request.getParameter("iptAdress"));
			user.setCountry(request.getParameter("slctCountry"));
			user.setPassword(password);
			
			User u = UserDAO.readUniqueUser(user);
			if(u != null) {
				url = "http://localhost:8080/FORM-JSP-SERVLET/index.jsp?msg=email";
			}else {
				UserDAO.createUser(user);
			}

		}
		response.sendRedirect(url);
	}

}

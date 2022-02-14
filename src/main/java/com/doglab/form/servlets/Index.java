package com.doglab.form.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;

import com.doglab.form.JPAUtil.JPAUtil;
import com.doglab.form.dao.UserDAO;
import com.doglab.form.users.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
			
			EntityManager em = JPAUtil.getEntityManager();
			UserDAO userDao = new UserDAO(em);
			
			em.getTransaction().begin();

			User u = userDao.readUniqueUser(user);
			
			if(u != null) {
				url = "http://localhost:8080/FORM-JSP-SERVLET/index.jsp?msg=email";
			}else {
				userDao.createUser(user);
			}
			
			em.getTransaction().commit();
			em.close();
		}
		response.sendRedirect(url);
	}

}

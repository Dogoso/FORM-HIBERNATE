package com.doglab.form.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import com.doglab.form.JPAUtil.JPAUtil;
import com.doglab.form.dao.UserDAO;
import com.doglab.form.users.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String url = "http://localhost:8080/FORM-JSP-SERVLET/login.jsp?msg=error";
		User user = new User();
		user.setEmail(req.getParameter("iptEmail"));
		user.setPassword(req.getParameter("iptPassword"));
		
		EntityManager em = JPAUtil.getEntityManager();
		UserDAO userDao = new UserDAO(em);
		em.getTransaction().begin();
		
		List<User> users = userDao.readUsers();
		
		em.getTransaction().commit();
		em.close();
		
		for(User u : users) {
			if(u.getEmail().equals(user.getEmail())) {
				if(u.getPassword().equals(user.getPassword())) { // Login Realizado
					Cookie cookie = new Cookie("email", user.getEmail());
					cookie.setMaxAge(60*60*24*30);
					res.addCookie(cookie);
					
					HttpSession session = req.getSession();
					session.setAttribute("user", u.getName()+" "+u.getSurname());
					url = "http://localhost:8080/FORM-JSP-SERVLET/users.jsp";
				}
			}
		}
		
		try {
			res.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

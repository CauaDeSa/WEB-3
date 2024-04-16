package br.edu.ifsp.arqweb1.ifitness.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arqweb1.ifitness.model.User;
import br.edu.ifsp.arqweb1.ifitness.model.util.users.UserLogin;

@WebServlet("/login")
public class UserLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int cookieMaxAge = 60 * 60 * 24;

	public UserLoginController() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = UserLogin.login(email, password);
		RequestDispatcher dispatcher = null;
		
		if (user != null) {
			Cookie cookie = new Cookie("loggedUser", email);
			cookie.setMaxAge(cookieMaxAge);
			resp.addCookie(cookie);
			
			req.setAttribute("user", user);
			dispatcher = req.getRequestDispatcher("/homePageServlet");
		} else {
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie c: cookies) {
					if (c.getName().equals("loggedUser")) {
						c.setMaxAge(0);
						resp.addCookie(c);
					}
				}
			}
			
			req.setAttribute("result", "notFound");
			dispatcher =req.getRequestDispatcher("/login.jsp");
		}

		dispatcher.forward(req, resp);
	}
}
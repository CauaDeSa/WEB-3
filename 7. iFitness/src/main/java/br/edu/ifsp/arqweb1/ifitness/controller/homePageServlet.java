package br.edu.ifsp.arqweb1.ifitness.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arqweb1.ifitness.model.Activity;
import br.edu.ifsp.arqweb1.ifitness.model.User;
import br.edu.ifsp.arqweb1.ifitness.model.util.activities.ActivityReader;
import br.edu.ifsp.arqweb1.ifitness.model.util.users.UsersReader;

@WebServlet("/homePageServlet")
public class homePageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public homePageServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getAttribute("user");
		RequestDispatcher dispatcher = null;
	
		if(user != null) {
			List<Activity> userActivities = ActivityReader.readByUser(user);
		
			req.setAttribute("userActivities", userActivities);
			req.setAttribute("name", user.getName());
			System.out.println("dispatcher!");
			dispatcher = req.getRequestDispatcher("/homePage.jsp");
			System.out.println("dispatcher?");
		} else {
			Cookie[] cookies = req.getCookies();
			System.out.println("Oi");
			if(cookies != null) {
				
				for(Cookie c: cookies) {
					if(c.getName().equals("loggedUser")) {
						user = UsersReader.findUserByEmail(c.getValue());
					}
				}
			}
			
			if(user != null) {
				List<Activity> userActivities = ActivityReader.readByUser(user);
			
				req.setAttribute("userActivities", userActivities);
				req.setAttribute("name", user.getName());
				
				dispatcher = req.getRequestDispatcher("/homePage.jsp");
			} else {
				req.setAttribute("result", "notFound");
				dispatcher = req.getRequestDispatcher("/login.jsp");
			}
		
	}
	dispatcher.forward(req, resp);
}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
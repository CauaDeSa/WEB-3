package br.edu.ifsp.arqweb1.ifitness.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arqweb1.ifitness.model.User;
import br.edu.ifsp.arqweb1.ifitness.model.util.users.UserLogin;

@WebServlet("/activityRegister")
public class UserLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserLoginController() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		RequestDispatcher dispatcher = null;

		try {
			User user = UserLogin.login(email, password);
			req.setAttribute("user", user);
			dispatcher = req.getRequestDispatcher("/activity-register.jsp");
		} catch (Exception e) {
			req.setAttribute("result", "notFound");
			dispatcher =req.getRequestDispatcher("/login.jsp");
		}
		
		dispatcher.forward(req, resp);
	}
}
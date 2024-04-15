package br.edu.ifsp.arqweb1.ifitness.controller;

import java.io.IOException;
import java.time.LocalDate;

import br.edu.ifsp.arqweb1.ifitness.model.Gender;
import br.edu.ifsp.arqweb1.ifitness.model.User;
import br.edu.ifsp.arqweb1.ifitness.model.util.users.UsersWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userRegister")
public class UserRegisterController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public UserRegisterController() {
    	super();
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dateOfBirth = req.getParameter("dateOfBirth");
		String gender = req.getParameter("gender");
		
		User user = new User(name, email, password, LocalDate.parse(dateOfBirth), Gender.valueOf(gender));
		
		RequestDispatcher dispatcher = null;
		
		if(UsersWriter.write(user)) {
			req.setAttribute("result", "registered");
			dispatcher = req.getRequestDispatcher("/login.jsp");
		} else {
			req.setAttribute("result", "notRegistered");
			dispatcher = req.getRequestDispatcher("/user-register.jsp");
		}
		
		dispatcher.forward(req, resp);
	}
}
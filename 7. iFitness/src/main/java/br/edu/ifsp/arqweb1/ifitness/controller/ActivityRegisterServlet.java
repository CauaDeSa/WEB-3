package br.edu.ifsp.arqweb1.ifitness.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arqweb1.ifitness.model.Activity;
import br.edu.ifsp.arqweb1.ifitness.model.ActivityType;
import br.edu.ifsp.arqweb1.ifitness.model.User;
import br.edu.ifsp.arqweb1.ifitness.model.util.activities.ActivityWriter;
import br.edu.ifsp.arqweb1.ifitness.model.util.users.UsersReader;

@WebServlet("/activityRegister")
public class ActivityRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public ActivityRegisterServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActivityType type = ActivityType.valueOf
				(req.getParameter("activityType"));
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		Double distance = 
				Double.parseDouble(req.getParameter("distance"));
		Double duration = 
				Double.parseDouble(req.getParameter("duration"));
		
		User user = null;
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (Cookie c: cookies ) {
				if (c.getName().equals("loggedUser"))
					user = UsersReader.findUserByEmail(c.getValue());
			}
		}
		
		RequestDispatcher dispatcher = null;
		
		if (user != null) {
			Activity activity = new Activity();
			activity.setType(type);
			activity.setDate(date);
			activity.setDistance(distance);
			activity.setDuration(duration);
			activity.setUser(user);
			if(ActivityWriter.write(activity)) {
				req.setAttribute("result", "registered");
				dispatcher = 
						req.getRequestDispatcher("/activity-register.jsp");
			}
		} else {
			req.setAttribute("result", "notRegistered");
			dispatcher = req.getRequestDispatcher("/activity-register.jsp");
		}
		
		
		dispatcher.forward(req, resp);
	}
}
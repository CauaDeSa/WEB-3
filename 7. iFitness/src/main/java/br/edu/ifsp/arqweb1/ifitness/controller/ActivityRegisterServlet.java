package br.edu.ifsp.arqweb1.ifitness.controller;

import java.io.IOException;
import java.time.LocalDate;
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

	private static final long serialVersionUID = -5839886053047740115L;
	
	public ActivityRegisterServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
	        Activity activity = createActivity(req);
	        
			if (ActivityWriter.write(activity)) {
				req.setAttribute("result", "registered");
				req.setAttribute("activity", activity);
			} else {
				req.setAttribute("result", "notRegistered");
			}
			
		} catch (Exception e) {
			req.setAttribute("result", "notRegistered");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("./activity-register.jsp").forward(req, resp);
	}
	
	private Activity createActivity(HttpServletRequest req) throws Exception {
		
		ActivityType activityType = ActivityType.valueOf(req.getParameter("activityType"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        Double distance = Double.parseDouble(req.getParameter("distance"));
        Double duration = Double.parseDouble(req.getParameter("duration"));
        User user = null;
        
        Cookie[] cookies = req.getCookies();
        
		if (cookies != null) {
			try {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("userId")) {
						user = UsersReader.findUserByEmail(cookie.getValue());
					}
				}
			} catch (Exception e) {
				throw new Exception("User not found");
			}
		}
		
		return new Activity(activityType, date, duration, distance, user);
	}

}
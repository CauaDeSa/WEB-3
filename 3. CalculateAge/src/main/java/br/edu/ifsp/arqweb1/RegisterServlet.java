package br.edu.ifsp.arqweb1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public RegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String fullName = req.getParameter("fullName");
		String age = req.getParameter("date");

		LocalDate date = LocalDate.parse(age);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
			writer.println("\t<meta charset=\"UTF-8\" >");
			writer.println("\t<title>Página de Resposta</title>");		
		writer.println("</head>");
		
		writer.println("<body>");
			writer.println("<section>");
				writer.println("\t<h2>" + fullName + "</h2>");
				writer.println("\t<h2>Você possui " + calculateAge(date) + " anos!</h2>");
			writer.println("</section>");
		writer.println("</body>");
		
		writer.println("</html>");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private int calculateAge(LocalDate bornDate) {
		int age;
		
		LocalDate todate = LocalDate.now();
		
		age = todate.getYear() - bornDate.getYear();
		
		if(todate.getDayOfYear() < bornDate.getDayOfYear()) {
			age--;
		}
		
		return age;
	}
	
	
}

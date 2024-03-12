package br.edu.ifsp.arqweb1;

import java.io.IOException;
import java.io.PrintWriter;

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
		String email = req.getParameter("email");
		String[] options = req.getParameterValues("options");
		StringBuilder selectedOptions = new StringBuilder("");
		
		for (String option : options) {
			selectedOptions.append(option).append(" ");
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
			writer.println("\t<meta charset=\"UTF-8\" >");
			writer.println("\t<title>Página de Resposta - Register App</title>");		
		writer.println("</head>");
		
		writer.println("<body>");
			writer.println("<section>");
				writer.println("\t<h1>Cadastro realizado com sucesso!</h1>");
				writer.println("\t<h2>Nome completo: " + fullName + "</h2>");
				writer.println("\t<h2>Email: " + email + "</h2>");
				writer.println("\t<h2>Interesses: " + selectedOptions.toString() + "</h2>");
			writer.println("</section>");
		writer.println("</body>");
		
		writer.println("</html>");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}

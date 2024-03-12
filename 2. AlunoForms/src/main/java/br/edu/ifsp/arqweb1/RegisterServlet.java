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
		String[] emails = req.getParameterValues("email");
		String[] options = req.getParameterValues("options");
		StringBuilder selectedOptions = new StringBuilder("");
		StringBuilder studentEmails = new StringBuilder("");
		boolean flag = false;
		
		for (String email : emails) {
			if (!flag) {
				studentEmails.append(email);
				flag = true;
			} else if (!emails[0].equals(emails[1])){
				studentEmails.append(" & ").append(email);
				
			}
		}
		
		flag = false;
		
		for (String option : options) {
			if (!flag) {
				selectedOptions.append(option);
				flag = true;
			} else {
				selectedOptions.append(", ").append(option);
			}
		}
		selectedOptions.append(".");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
			writer.println("\t<meta charset=\"UTF-8\" >");
			writer.println("\t<title>Página de Resposta - Registro de Aluno</title>");		
		writer.println("</head>");
		
		writer.println("<body>");
			writer.println("<section>");
				writer.println("\t<h1>Cadastro realizado com sucesso!</h1>");
				writer.println("\t<h2>Nome completo: " + fullName + "</h2>");
				writer.println("\t<h2>Email: " + studentEmails + "</h2>");
				
				if (selectedOptions.toString().equals("")) {
					throw new ServletException();
				} else {
					writer.println("\t<h2>Curso(s) de interesse: " + selectedOptions.toString() + "</h2>");
				}
				
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

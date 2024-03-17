package br.edu.ifsp.arqweb1.servletController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arqweb1.model.User;
import br.edu.ifsp.arqweb1.model.dao.UserDaoImpl;

@WebServlet("/Login")
public class servletController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	private UserDaoImpl dataset;
    
    public servletController() {
    	super();
    	dataset = UserDaoImpl.getInstance();
    	load();
    }
	    
	private void load(){
        dataset.insert(new User("cauarufinodesa@gmail.com", "12345678910"));
        dataset.insert(new User("igorfilippicardoso@gmail.com", "12345678910"));
        dataset.insert(new User("ednilsonrossi@gmail.com", "12345678910"));
    }	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if (User.autenticate(dataset.getByEmail(email), password)) {
			loginPage(req, resp, writer);
		} else {
			errorPage(req, resp, writer);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private void loginPage(HttpServletRequest req, HttpServletResponse resp, PrintWriter writer) {
		resp.setContentType("text/html;charset=UTF-8");
		
		writer.println("<html>");
		writer.println("<head>");
			writer.println("\t<meta charset=\"UTF-8\" >");
			writer.println("\t<title>Exito ao efetuar login</title>");	
			writer.println("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"responsePages.css\">");
		writer.println("</head>");
		
		writer.println("<body>");
			writer.println("<section>");
				writer.println("<h1> Login efetuado com sucesso! </h1>");
				writer.println("<img src=\"./assets/joinha.png\">");
			writer.println("</section>");
		writer.println("</body>");
		
		writer.println("</html>");
		writer.close();
	}
	
	private void errorPage(HttpServletRequest req, HttpServletResponse resp, PrintWriter writer) {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		writer.println("<html>");
		writer.println("<head>");
			writer.println("\t<meta charset=\"UTF-8\" >");
			writer.println("\t<title>Erro ao efetuar login</title>");	
			writer.println("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"responsePages.css\">");
		writer.println("</head>");
		
		writer.println("<body>");
			writer.println("<section>");
				writer.println("\t<h1>Não foi possível efetuar o login!</h1>");
				writer.println("<img src=\"./assets/sadCat.jpg\">");
				writer.println("\t<a href=\"index.html\" > Página de login </a>");
			writer.println("</section>");
		writer.println("</body>");
		
		writer.println("</html>");
		writer.close();
	}
}
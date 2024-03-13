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
		PrintWriter write = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if (dataset.validate(dataset.getByEmail(email), password)) {
			write.println("<h1> Login efetuado com sucesso! </h1>");
		} else {
			write.println("<h1> Não foi possível efetuar login! </h1>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
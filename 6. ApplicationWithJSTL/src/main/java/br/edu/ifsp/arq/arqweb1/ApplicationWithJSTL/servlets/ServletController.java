package br.edu.ifsp.arq.arqweb1.ApplicationWithJSTL.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.arqweb1.ApplicationWithJSTL.model.Person;
import br.edu.ifsp.arq.arqweb1.ApplicationWithJSTL.model.PersonUtil;

@WebServlet("/PersonInfo")
public class ServletController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data = req.getParameter("persons");
		PersonUtil personUtil = new PersonUtil();

		List<Person> persons = personUtil.getPersons(data);

		req.setAttribute("list", persons);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
	}
}
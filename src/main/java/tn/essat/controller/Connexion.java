package tn.essat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connexion
 */
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<HTML> ");
		out.println("<head></head> ");
		out.println("<body> ");
		out.println("<h2>Connexion </h2> ");
		out.println("<form method='GET' action='Verif'>");
		out.println("<p> Login:<input type='text' name='login'></p> ");
		out.println("<p> Password:<input type='text' name='password'></p> ");
		out.println("<p> <input type='submit' value='Connexion'></p> ");
		out.println("</form> ");
		
		String err1 = request.getParameter("err1");
		String err2 = request.getParameter("err2");
		String err3 = request.getParameter("err3");
		if (err1 != null) {
			out.println("<p>Vous n'avez pas le droit d'accéder avant d'etre connecter</p>");

		}
		if (err2 != null) {
			out.println("<p>Veuillez vérifier votre paramètre de connexion!!!</p>");
		}
		if (err3 != null) {
			out.println("<p>Merci pour votre visite mr/mlle!!!</p>");
		}
		out.println("</body> ");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

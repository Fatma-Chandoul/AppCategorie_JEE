package tn.essat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Categorie;
import tn.essat.model.User;

/**
 * Servlet implementation class ListeCat
 */
public class ListeCat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeCat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u1");
		if (u == null) {
			request.getRequestDispatcher("Connexion?err1=1").forward(request, response);
		}
		IGestion gest = new GestionImp();
		List<Categorie> liste = gest.getAllCategories();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>Liste de catégories</h2> ");
		out.println("Bonjour Mr/Mlle" + u.getNom() + "(<a href='Deconnexion'>Deconnexion</a></p>)");

		out.println("<table border=1>");
		for (Categorie c : liste) {
			out.println("<tr>");
			out.println("<td>" + c.getId() + "</td>");
			out.println("<td>" + c.getTitre() + "</td>");
			out.println("<td><a href='ListeProd?idcat=" + c.getId() + "'>liste des produits</a></td>");
			out.println("</tr>");
		}

		out.println("</table>");
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

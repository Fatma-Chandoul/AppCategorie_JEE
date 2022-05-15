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
import tn.essat.model.Produit;
import tn.essat.model.User;

/**
 * Servlet implementation class ListeProd
 */
public class ListeProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeProd() {
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
			int idCat = Integer.parseInt(request.getParameter("idcat"));
			Categorie cat = gest.getCategorieById(idCat);
			List<Produit> liste = gest.getAllProduitsByCatId(idCat);

			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Liste de produits(" + cat.getTitre() + ")</h2> ");
			out.println("Bonjour Mr/Mlle" + u.getNom() + "(<a href='Deconnexion'>Deconnexion</a>)</p>");

			out.println("<table border=1>");
			for (Produit p : liste) {
				out.println("<tr>");
				out.println("<td>" + p.getId() + "</td>");
				out.println("<td>" + p.getTitre() + "</td>");
				out.println("<td>" + p.getPrix() + "</td>");
				out.println("<td><a href='ListeProd?idcat=" + p.getId() + "'>liste des produits</a></td>");
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

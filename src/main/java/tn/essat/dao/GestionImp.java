package tn.essat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tn.essat.model.Categorie;

import tn.essat.model.Produit;
import tn.essat.model.User;

public class GestionImp implements IGestion {
	private Connection cnx;

	public GestionImp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/base888", "root", "");

		} catch (Exception e) {

		}

	}

	@Override
	public User verif(String login, String password) {
		User usr = null;
		try {
			PreparedStatement pre = this.cnx.prepareStatement("select * from user where login=? and password=?");

			pre.setString(1, login);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();// methode de selection
			if (rs.next()) {
				usr = new User();
				usr.setId(rs.getInt("id"));
				usr.setNom(rs.getString("nom"));
				usr.setLogin(rs.getString("login"));
				usr.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return usr;
	}

	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> liste = new ArrayList<Categorie>();
		try {
			PreparedStatement pre = this.cnx.prepareStatement("select * from categorie");
			ResultSet rs = pre.executeQuery();// methode de selection
			while (rs.next()) {
				Categorie c = new Categorie();
				c.setId(rs.getInt("id"));
				c.setTitre(rs.getString("titre"));
				liste.add(c);

			}

		} catch (Exception e) {

		}

		return liste;
	}

	@Override
	public List<Produit> getAllProduitsByCatId(int id) {
		List<Produit> liste = new ArrayList<Produit>();
		try {
			PreparedStatement pre = this.cnx.prepareStatement("select * from produit where cat_id=?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();// methode de selection
			while (rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getInt("id"));
				p.setTitre(rs.getString("titre"));
				p.setPrix(rs.getFloat("prix"));
				p.setCat(this.getCategorieById(rs.getInt("cat_id")));
				liste.add(p);

			}

		} catch (Exception e) {

		}

		return liste;
	}

	@Override
	public void addProduit(Produit p) {
		try {
			PreparedStatement pre = this.cnx.prepareStatement("insert into produit values (null,?,?,?)");
			// pre.setInt(1, p.getId());
			pre.setString(1, p.getTitre());
			pre.setFloat(2, p.getPrix());
			pre.setInt(3, p.getCat().getId());
			pre.executeUpdate();

		} catch (Exception e) {

		}
	}

	@Override
	public void addCCategorie(Categorie c) {
		try {
			PreparedStatement pre = this.cnx.prepareStatement("insert into categorie values (null,?)");
			// pre.setInt(1, c.getId());
			pre.setString(1, c.getTitre());
			pre.executeUpdate();

		} catch (Exception e) {

		}
	}

	@Override
	public void deleteProduit(int id) {
		try {
			PreparedStatement pre = this.cnx.prepareStatement("delete from produit where id=?");
			pre.setInt(1, id);
			pre.executeUpdate();

		} catch (Exception e) {

		}

	}

	@Override
	public Produit getProduitById(int id) {
		Produit p = new Produit();
		try {
			PreparedStatement pre = this.cnx.prepareStatement("select * from produit where cat_id =?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();// methode de selection
			if (rs.next()) {

				p.setId(rs.getInt("id"));
				p.setTitre(rs.getString("titre"));
				p.setPrix(rs.getFloat("prix"));
				p.setCat(getCategorieById(rs.getInt("cat_id")));

				// liste.add(et);

			}

		} catch (Exception e) {

		}
		return p;
	}

	@Override
	public Categorie getCategorieById(int id) {
		Categorie c = new Categorie();
		try {
			PreparedStatement pre = this.cnx.prepareStatement("select * from categorie where id =?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();// methode de selection
			if (rs.next()) {

				c.setId(rs.getInt("id"));
				c.setTitre(rs.getString("titre"));
				// liste.add(et);

			}

		} catch (Exception e) {

		}
		return c;

	}

}

package tn.essat.dao;

import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Produit;
import tn.essat.model.User;

public interface IGestion {
	public User verif(String login, String password);

	public List<Categorie> getAllCategories();

	public List<Produit> getAllProduitsByCatId(int id);

	public void addProduit(Produit p);

	public void addCCategorie(Categorie c);

	public void deleteProduit(int id);

	public Produit getProduitById(int id);

	public Categorie getCategorieById(int id);

}

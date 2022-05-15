package tn.essat.model;

public class Categorie {
	private int id;
	private String titre;

	public Categorie(int id, String t) {
		super();
		this.id = id;
		this.titre = t;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}

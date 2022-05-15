package tn.essat.model;

public class Produit {
	private int id;
	private String titre;
	private float prix;
	private Categorie cat;

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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	public Produit(int id, String titre, float prix, Categorie cat) {
		super();
		this.id = id;
		this.titre = titre;
		this.prix = prix;
		this.cat = cat;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

}

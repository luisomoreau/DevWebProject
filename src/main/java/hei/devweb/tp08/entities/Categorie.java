package hei.devweb.tp08.entities;

public class Categorie {
	private Integer idCategorie;
	private String nameCategorie;

	public Categorie(Integer idCategorie, String nameCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.nameCategorie = nameCategorie;
	}

	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNameCategorie() {
		return nameCategorie;
	}

	public void setNameCategorie(String nameCategorie) {
		this.nameCategorie = nameCategorie;
	}
}

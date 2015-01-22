package hei.devweb.tp08.entities;

import java.util.Date;

public class Film {
	private Integer id;
	private String titre;
	private Date dateDeSortie;
	private Genre genre;
	private Integer duree;
	private String realisateur;
	private String resume;

	public Film(Integer id, String titre, Date dateDeSortie, Genre genre, Integer duree, String realisateur, String resume) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateDeSortie = dateDeSortie;
		this.genre = genre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.resume = resume;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}

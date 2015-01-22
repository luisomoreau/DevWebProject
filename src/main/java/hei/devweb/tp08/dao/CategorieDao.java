package hei.devweb.tp08.dao;

import hei.devweb.tp08.entities.Categorie;

import java.util.List;

public interface CategorieDao {
	public List<Categorie> listerCategorie();

	public Categorie getCategorie(Integer idCategorie);

	public Categorie ajouterCategorie(String nameCategorie);
}

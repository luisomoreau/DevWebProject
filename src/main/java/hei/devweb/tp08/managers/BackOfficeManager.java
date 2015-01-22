package hei.devweb.tp08.managers;

import hei.devweb.tp08.dao.CategorieDao;
import hei.devweb.tp08.dao.GenreDao;
import hei.devweb.tp08.dao.impl.CategorieDaoMysqlImpl;
import hei.devweb.tp08.dao.impl.GenreDaoMysqlImpl;
import hei.devweb.tp08.entities.Categorie;
import hei.devweb.tp08.entities.Genre;

import java.util.List;

public class BackOfficeManager {

	private static BackOfficeManager instance;

	public static BackOfficeManager getInstance() {
		if (instance == null) {
			instance = new BackOfficeManager();
		}
		return instance;
	}

	private CategorieDao categorieDao = new CategorieDaoMysqlImpl();
	private GenreDao genreDao = new GenreDaoMysqlImpl();

	private BackOfficeManager() {
	}

	public List<Categorie> listerFilms() {
		return categorieDao.listerCategorie();
	}

	public Categorie getFilm(Integer id) {
		return categorieDao.getCategorie(id);
	}

	public Categorie ajouterFilm(String nameCategorie) {
		return categorieDao.ajouterCategorie(nameCategorie);
	}


	public List<Genre> listerGenres() {
		return genreDao.listerGenres();
	}

	public Genre getGenre(Integer id) {
		return genreDao.getGenre(id);
	}

	public Genre ajouterGenre(String nom) {
		return genreDao.ajouterGenre(nom);
	}

}

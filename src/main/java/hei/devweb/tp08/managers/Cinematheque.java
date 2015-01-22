package hei.devweb.tp08.managers;

import hei.devweb.tp08.dao.FilmDao;
import hei.devweb.tp08.dao.GenreDao;
import hei.devweb.tp08.dao.impl.FilmDaoMysqlImpl;
import hei.devweb.tp08.dao.impl.GenreDaoMysqlImpl;
import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.entities.Genre;

import java.util.List;

public class Cinematheque {

	private static Cinematheque instance;

	public static Cinematheque getInstance() {
		if (instance == null) {
			instance = new Cinematheque();
		}
		return instance;
	}

	private FilmDao filmDao = new FilmDaoMysqlImpl();
	private GenreDao genreDao = new GenreDaoMysqlImpl();

	private Cinematheque() {
	}

	public List<Film> listerFilms() {
		return filmDao.listerFilms();
	}

	public Film getFilm(Integer id) {
		return filmDao.getFilm(id);
	}

	public Film ajouterFilm(Film film) {
		return filmDao.ajouterFilm(film);
	}

	public Film getFilmAleatoire() {
		Integer identifiantAleatoire = filmDao.getIdentifiantFilmAleatoire();
		return filmDao.getFilm(identifiantAleatoire);
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

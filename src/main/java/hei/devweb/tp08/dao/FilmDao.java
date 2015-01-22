package hei.devweb.tp08.dao;

import hei.devweb.tp08.entities.Film;

import java.util.List;

public interface FilmDao {
	public List<Film> listerFilms();

	public Film getFilm(Integer id);

	public Film ajouterFilm(Film film);

	public Integer getIdentifiantFilmAleatoire();
}

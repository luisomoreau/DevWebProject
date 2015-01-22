package hei.devweb.tp08.dao;

import hei.devweb.tp08.entities.Genre;

import java.util.List;

public interface GenreDao {
	public List<Genre> listerGenres();

	public Genre getGenre(Integer id);

	public Genre ajouterGenre(String nom);
}

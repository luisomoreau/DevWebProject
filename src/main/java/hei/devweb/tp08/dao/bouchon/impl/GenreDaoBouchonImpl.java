package hei.devweb.tp08.dao.bouchon.impl;

import hei.devweb.tp08.dao.GenreDao;
import hei.devweb.tp08.entities.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GenreDaoBouchonImpl implements GenreDao {

	private TreeMap<Integer, Genre> listeGenres;

	public GenreDaoBouchonImpl() {
		listeGenres = new TreeMap<Integer, Genre>();
		listeGenres.put(1, new Genre(1, "Science-fiction"));
		listeGenres.put(2, new Genre(2, "Drame"));
		listeGenres.put(3, new Genre(3, "Action"));
		listeGenres.put(4, new Genre(4, "Comédie"));
		listeGenres.put(5, new Genre(5, "Comédie dramatique"));
	}

	public List<Genre> listerGenres() {
		return new ArrayList<Genre>(listeGenres.values());
	}

	public Genre getGenre(Integer id) {
		return listeGenres.get(id);
	}

	public Genre ajouterGenre(String nom) {
		Integer id = listeGenres.lastKey() + 1;
		Genre genre = new Genre(id, nom);
		listeGenres.put(id, genre);
		return genre;
	}
}

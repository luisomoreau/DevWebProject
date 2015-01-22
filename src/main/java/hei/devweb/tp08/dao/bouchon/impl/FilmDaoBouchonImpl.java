package hei.devweb.tp08.dao.bouchon.impl;

import hei.devweb.tp08.dao.FilmDao;
import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.entities.Genre;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TreeMap;

public class FilmDaoBouchonImpl implements FilmDao {
	private TreeMap<Integer, Film> listeFilms;

	public FilmDaoBouchonImpl() {
		listeFilms = new TreeMap<Integer, Film>();
		listeFilms.put(1, new Film(1, "Interstellar", this.genererDate(2014, Calendar.NOVEMBER, 5), new Genre(1, "Science-fiction"), 169, "Christopher Nolan",
				"Un groupe d'explorateurs exploite une faille dans l'espace-temps afin de parcourir des distances incroyables dans le but de sauver l'humanité."));
		listeFilms.put(2, new Film(2, "Quand vient la nuit", this.genererDate(2014, Calendar.NOVEMBER, 12), new Genre(3, "Action"), 107, "Michael R. Roskam",
				"Le gérant d'un bar new-yorkais, impliqué dans les affaires de la mafia locale, est poursuivi par l'ancien propriétaire d'un chien qu'il a sauvé de la mort."));
		listeFilms.put(3, new Film(3, "Hunger Games : La Révolte, partie 1", this.genererDate(2014, Calendar.NOVEMBER, 19), new Genre(3, "Action"), 125,
				"Francis Lawrence",
				"Katniss est devenue le symbole d'une rébellion contre le pouvoir totalitaire. Son destin, celui de ses proches, et celui de Panem sont en jeu."));
		listeFilms.put(4, new Film(4, "Vie sauvage", this.genererDate(2014, Calendar.OCTOBER, 29), new Genre(5, "Comédie dramatique"), 106, "Cédric Kahn",
				"Après sa séparation avec sa femme, qui a eu la garde des enfants, Paco est venu les chercher pour partir en cavale dans le sud pendant des années."));
		listeFilms.put(5, new Film(5, "Puzzle", this.genererDate(2014, Calendar.NOVEMBER, 19), new Genre(2, "Drame"), 137, "Paul Haggis",
				"Michael quitte sa femme, Scott vient en aide à une jeune tzigane et Julia tente de récupérer son fils. Malgré leurs différences, un secret les lie."));
		listeFilms.put(6, new Film(6, "The Giver", this.genererDate(2014, Calendar.OCTOBER, 29), new Genre(2, "Drame"), 97, "Phillip Noyce",
				"Dans un futur lointain, les émotions ont été éradiquées en supprimant l'histoire. Seul The Giver a la lourde tâche de se souvenir du passé."));

	}

	public List<Film> listerFilms() {
		return new ArrayList<Film>(listeFilms.values());
	}

	public Film getFilm(Integer id) {
		return listeFilms.get(id);
	}

	public Film ajouterFilm(Film film) {
		Integer id = listeFilms.lastKey() + 1;
		film.setId(id);
		listeFilms.put(id, film);
		return film;
	}

	private Date genererDate(int annee, int mois, int jour) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(annee, mois, jour);

		return cal.getTime();
	}

	@Override
	public Integer getIdentifiantFilmAleatoire() {
		return 1;
	}
}

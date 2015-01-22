package hei.devweb.tp08.dao.impl;

import hei.devweb.tp08.dao.FilmDao;
import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.entities.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilmDaoTestCase {
	private FilmDao filmDao = new FilmDaoMysqlImpl();

	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM film");
		stmt.executeUpdate("DELETE FROM genre");
		stmt.executeUpdate("INSERT INTO `genre`(`idgenre`,`nom`) VALUES (1,'Drame')");
		stmt.executeUpdate("INSERT INTO `genre`(`idgenre`,`nom`) VALUES (2,'Comédie')");
		stmt.executeUpdate("INSERT INTO `film`(`idfilm`,`titre`, datedesortie, idgenre, duree, realisateur, resume) "
				+ "VALUES (1, 'mon titre 1', '2014-11-26', 1, 120, 'réalisateur n°1', 'résumé')");
		stmt.executeUpdate("INSERT INTO `film`(`idfilm`,`titre`, datedesortie, idgenre, duree, realisateur, resume) "
				+ "VALUES (2, 'titre film 2', '2014-10-26', 2, 165, 'réalisateur n°2', 'résumé')");
		stmt.close();
		connection.close();
	}

	@Test
	public void testerListerFilms() {
		List<Film> films = filmDao.listerFilms();
		Assert.assertEquals(2, films.size());
		Assert.assertEquals(1, films.get(0).getId().intValue());

		Assert.assertEquals(2, films.get(1).getId().intValue());
		Assert.assertEquals("titre film 2", films.get(1).getTitre());
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2014, Calendar.OCTOBER, 26, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(cal.getTime(), films.get(1).getDateDeSortie());
		Assert.assertEquals(2, films.get(1).getGenre().getId().intValue());
		Assert.assertEquals("Comédie", films.get(1).getGenre().getNom());
		Assert.assertEquals(165, films.get(1).getDuree().intValue());
		Assert.assertEquals("réalisateur n°2", films.get(1).getRealisateur());
		Assert.assertEquals("résumé", films.get(1).getResume());

	}

	@Test
	public void testerGetFilm() {
		Film film = filmDao.getFilm(2);
		Assert.assertNotNull(film);
		Assert.assertEquals(2, film.getId().intValue());
		Assert.assertEquals("titre film 2", film.getTitre());
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2014, Calendar.OCTOBER, 26, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(cal.getTime(), film.getDateDeSortie());
		Assert.assertEquals(2, film.getGenre().getId().intValue());
		Assert.assertEquals("Comédie", film.getGenre().getNom());
		Assert.assertEquals(165, film.getDuree().intValue());
		Assert.assertEquals("réalisateur n°2", film.getRealisateur());
		Assert.assertEquals("résumé", film.getResume());
	}

	@Test
	public void testerAjouterFilm() throws Exception {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2014, Calendar.NOVEMBER, 28, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Film film = new Film(null, "test titre", cal.getTime(), new Genre(1, "Drame"), 100, "test realisateur", "test resume");

		Film filmAjoute = filmDao.ajouterFilm(film);
		Assert.assertNotNull(filmAjoute);
		Assert.assertNotNull(filmAjoute.getId());

		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM film WHERE idfilm = ?");
		stmt.setInt(1, filmAjoute.getId());
		ResultSet rs = stmt.executeQuery();
		Assert.assertTrue(rs.next());
		Assert.assertEquals(filmAjoute.getId().intValue(), rs.getInt("idfilm"));
		Assert.assertEquals("test titre", rs.getString("titre"));
		Assert.assertEquals(cal.getTime(), rs.getDate("datedesortie"));
		Assert.assertEquals(1, rs.getInt("idgenre"));
		Assert.assertEquals(100, rs.getInt("duree"));
		Assert.assertEquals("test realisateur", rs.getString("realisateur"));
		Assert.assertEquals("test resume", rs.getString("resume"));
		Assert.assertFalse(rs.next());
		connection.close();
	}

	@Test
	public void testerGetIdentifiantFilmAleatoire() throws Exception {
		Integer identifiant = filmDao.getIdentifiantFilmAleatoire();
		Assert.assertNotNull(identifiant);

		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT count(*) as nb FROM film WHERE idfilm = ?");
		stmt.setInt(1, identifiant);
		ResultSet rs = stmt.executeQuery();
		Assert.assertTrue(rs.next());
		Assert.assertEquals(1, rs.getInt("nb"));
		connection.close();
	}
}

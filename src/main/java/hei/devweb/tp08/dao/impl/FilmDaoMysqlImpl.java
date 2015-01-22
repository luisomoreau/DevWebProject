package hei.devweb.tp08.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.tp08.dao.FilmDao;
import hei.devweb.tp08.entities.Film;
import hei.devweb.tp08.entities.Genre;

public class FilmDaoMysqlImpl implements FilmDao {

	@Override
	public List<Film> listerFilms() {
		List<Film> films = new ArrayList<Film>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM film JOIN genre ON film.idgenre = genre.idgenre ORDER BY titre");
			while (rs.next()) {
				films.add(new Film(rs.getInt("idfilm"), rs.getString("titre"), rs.getDate("datedesortie"), new Genre(rs.getInt("genre.idgenre"),
						rs.getString("nom")), rs.getInt("duree"), rs.getString("realisateur"), rs.getString("resume")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Film getFilm(Integer id) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM film JOIN genre ON film.idgenre = genre.idgenre Where idfilm=?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Film(rs.getInt("idfilm"), rs.getString("titre"), rs.getDate("datedesortie"), new Genre(rs.getInt("genre.idgenre"),
						rs.getString("nom")), rs.getInt("duree"), rs.getString("realisateur"), rs.getString("resume"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Film ajouterFilm(Film film) {
		try {

			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO film(titre, datedesortie, idgenre, duree, realisateur, resume) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitre());
			stmt.setDate(2, new Date(film.getDateDeSortie().getTime()));
			stmt.setInt(3, film.getGenre().getId());
			stmt.setInt(4, film.getDuree());
			stmt.setString(5, film.getRealisateur());
			stmt.setString(6, film.getResume());
			stmt.executeUpdate();

			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				return new Film(ids.getInt(1), film.getTitre(), film.getDateDeSortie(), film.getGenre(), film.getDuree(), film.getRealisateur(),
						film.getResume());
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer getIdentifiantFilmAleatoire() {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();
			// Attention : La requête ci-dessous n'est pas adaptée pour les tables avec beaucoup de lignes
			ResultSet rs = stmt.executeQuery("SELECT idfilm from film order by RAND() LIMIT 1");
			if (rs.next()) {
				return rs.getInt("idfilm");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}

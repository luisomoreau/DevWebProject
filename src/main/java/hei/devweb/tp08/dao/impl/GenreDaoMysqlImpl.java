package hei.devweb.tp08.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.tp08.dao.GenreDao;
import hei.devweb.tp08.entities.Genre;

public class GenreDaoMysqlImpl implements GenreDao {

	@Override
	public List<Genre> listerGenres() {
		List<Genre> genres = new ArrayList<Genre>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT idgenre, nom FROM genre ORDER BY nom");
			while (rs.next()) {
				genres.add(new Genre(rs.getInt("idgenre"), rs.getString("nom")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}

	@Override
	public Genre getGenre(Integer id) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT idgenre, nom FROM genre WHERE idgenre = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Genre(rs.getInt("idgenre"), rs.getString("nom"));
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Genre ajouterGenre(String nom) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO genre(nom) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nom);
			stmt.executeUpdate();

			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				return new Genre(ids.getInt(1), nom);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

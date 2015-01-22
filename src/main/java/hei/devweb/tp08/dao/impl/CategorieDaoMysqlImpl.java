package hei.devweb.tp08.dao.impl;

import hei.devweb.tp08.dao.CategorieDao;
import hei.devweb.tp08.entities.Categorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategorieDaoMysqlImpl implements CategorieDao {

	@Override
	public List<Categorie> listerCategorie() {
		List<Categorie> categorie = new ArrayList<Categorie>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT idCategorie, nom FROM categorie ORDER BY nameCategorie");
			while (rs.next()) {
				categorie.add(new Categorie(rs.getInt("idCategorie"), rs.getString("nameCategorie")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

	@Override
	public Categorie getCategorie(Integer id) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT idCategorie, nom FROM categorie WHERE idCategorie = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Categorie(rs.getInt("idCategorie"), rs.getString("nameCategorie"));
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Categorie ajouterCategorie(String nom) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO genre(nom) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nom);
			stmt.executeUpdate();

			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				return new Categorie(ids.getInt(1), nom);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

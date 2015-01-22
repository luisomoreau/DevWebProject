package hei.devweb.tp08.dao.impl;

import hei.devweb.tp08.dao.ProduitDao;
import hei.devweb.tp08.entities.Categorie;
import hei.devweb.tp08.entities.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProduitDaoMysqlImpl implements ProduitDao {

	@Override
	public List<Produit> listerProduit() {
		List<Produit> produit = new ArrayList<Produit>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM produit JOIN categorie ON produit.idCategoryProduit = categorie.idCategorie BY nameProduit");
			while (rs.next()) {
				produit.add(new Produit(rs.getInt("idProduit"), rs.getString("nameProduit"), new Categorie(rs.getInt("categorie.idCategorie"),rs.getString("nameCategorie")), 
						rs.getString("imagePathProduit"),rs.getString("descProduit")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produit;
	}

	@Override
	public Produit getProduit(Integer id) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM produit JOIN categorie ON produit.idCategoryProduit = categorie.idCategorie  WHERE idProduit = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Produit(rs.getInt("idProduit"), rs.getString("nameProduit"), new Categorie(rs.getInt("categorie.idCategorie"),rs.getString("nameCategorie")),
						rs.getString("imagePathProduit"),rs.getString("descProduit"));
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Produit ajouterProduit(Produit produit) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO produit(nameProduit, idCategoryProduit, imagePathProduit, imagePathProduit, descProduit) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produit.getNameProduit());
			stmt.setInt(2, produit.getCategorie().getIdCategorie());
			stmt.setString(3, produit.getImagePathProduit());
			stmt.setString(4, produit.getDescProduit());
			stmt.executeUpdate();

			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				return new Produit(ids.getInt(1), produit.getNameProduit(), produit.getCategorie(), produit.getImagePathProduit(), produit.getDescProduit());
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

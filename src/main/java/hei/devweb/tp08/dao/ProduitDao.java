package hei.devweb.tp08.dao;

import hei.devweb.tp08.entities.Produit;

import java.util.List;

public interface ProduitDao {
	public List<Produit> listerProduit();

	public Produit getProduit(Integer idProduit);

	public Produit ajouterProduit(Produit produit);
}

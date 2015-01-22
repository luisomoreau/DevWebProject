package hei.devweb.tp08.managers;

import hei.devweb.tp08.dao.CategorieDao;
import hei.devweb.tp08.dao.ProduitDao;
import hei.devweb.tp08.dao.impl.CategorieDaoMysqlImpl;
import hei.devweb.tp08.dao.impl.ProduitDaoMysqlImpl;
import hei.devweb.tp08.entities.Categorie;
import hei.devweb.tp08.entities.Produit;

import java.util.List;

public class BackOfficeManager {

	private static BackOfficeManager instance;

	public static BackOfficeManager getInstance() {
		if (instance == null) {
			instance = new BackOfficeManager();
		}
		return instance;
	}

	private CategorieDao categorieDao = new CategorieDaoMysqlImpl();
	private ProduitDao produitDao = new ProduitDaoMysqlImpl();
	//private GenreDao genreDao = new GenreDaoMysqlImpl();

	private BackOfficeManager() {
	}

	public List<Categorie> listerCategorie() {
		return categorieDao.listerCategorie();
	}

	public Categorie getCategorie(Integer id) {
		return categorieDao.getCategorie(id);
	}

	public Categorie ajouterCategorie(String nameCategorie) {
		return categorieDao.ajouterCategorie(nameCategorie);
	}

	public List<Produit> listerProduit() {
		return produitDao.listerProduit();
	}

	public Produit getProduit(Integer id) {
		return produitDao.getProduit(id);
	}

	public Produit ajouterProduit(Produit produit) {
		return produitDao.ajouterProduit(produit);
	}
	

}

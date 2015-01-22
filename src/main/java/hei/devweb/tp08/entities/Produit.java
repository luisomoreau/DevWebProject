package hei.devweb.tp08.entities;

/**
 * Created by Louis on 22/01/2015.
 */
public class Produit {

    private Integer idProduit;
    private String nameProduit;
    private Categorie categorie;
    private String imagePathProduit;
    private String descProduit;

    public Produit(Integer idProduit, String nameProduit,Categorie categorie, String imagePathProduit, String descProduit) {
        super();
        this.idProduit = idProduit;
        this.nameProduit = nameProduit;
        this.categorie = categorie;
        this.imagePathProduit = imagePathProduit;
        this.descProduit = descProduit;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNameProduit() {
        return nameProduit;
    }

    public void setNameProduit(String nameProduit) {
        this.nameProduit = nameProduit;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getImagePathProduit() {
        return imagePathProduit;
    }

    public void setImagePathProduit(String imagePathProduit) {
        this.imagePathProduit = imagePathProduit;
    }

    public String getDescProduit() {
        return descProduit;
    }

    public void setDescProduit(String descProduit) {
        this.descProduit = descProduit;
    }
}

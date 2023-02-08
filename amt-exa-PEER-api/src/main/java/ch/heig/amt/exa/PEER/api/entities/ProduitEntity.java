package ch.heig.amt.exa.PEER.api.entities;


import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

enum StatusLivraison {
    dispo, colis, livre
}


@Entity(name = "Produit")
@Table(name = "Produits")
public class ProduitEntity {

    @TableGenerator(name = "genProduits",
            table = "idProduits",
            pkColumnName = "name",
            valueColumnName = "val",
            initialValue = 7,
            allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "genProduits")
    private int prd_num;

    @Size(max = 20)
    private String description;

    @Column(nullable = false)
    @Min(1)
    @Max(1000)
    private int poids;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusLivraison status_livraison;

    @ManyToOne
    @JoinColumn(name = "vil_num")
    private VilleEntity ville;

    public ProduitEntity() {}

    public ProduitEntity(int prd_num, String description, int poids, StatusLivraison status_livraison, VilleEntity ville) {
        this.prd_num = prd_num;
        this.description = description;
        this.poids = poids;
        this.status_livraison = status_livraison;
        this.ville = ville;
    }

    public int getPrd_num() {
        return prd_num;
    }
    public void setPrd_num(int prd_num) {
        this.prd_num = prd_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getStatus_livraison() {
        return status_livraison.toString();
    }

    public void setStatus_livraison(String status_livraison) {
        this.status_livraison = status_livraison.equals("dispo") ? StatusLivraison.dispo : status_livraison.equals("colis") ? StatusLivraison.colis : StatusLivraison.livre;
    }

    public VilleEntity getVille() {
        return ville;
    }

    public void setVille(VilleEntity ville) {
        this.ville = ville;
    }


}

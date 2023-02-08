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

    // status_livraison, obligatoire, valeurs possibles : 'dispo', 'colis', 'livre'

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private String status_livraison;

    @ManyToOne
    @JoinColumn(name = "vil_num")
    private VilleEntity ville;

}

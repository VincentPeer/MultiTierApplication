package ch.heig.amt.exa.PEER.api.entities;


import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity(name = "Ville")
@Table(name = "Villes")
public class VilleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vil_num;

    @Size(max = 10)
    private String nom;

    public VilleEntity() {}

    public VilleEntity(int vil_num, String nom) {
        this.vil_num = vil_num;
        this.nom = nom;
    }

    public int getId() {
        return vil_num;
    }

    public void setId(int vil_num) {
        this.vil_num = vil_num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

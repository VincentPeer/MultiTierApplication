package ch.heig.amt.exa.PEER.api.endpoints;

import ch.heig.amt.exa.PEER.api.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitsEndPoint {

    @Autowired
    private ProduitRepository produitsRepository;

/*    @Override
    public ResponseEntity<List<Produit>> getProduits() {
        List<ProduitEntity> produitEntities= produitsRepository.findAll();
        List<Produit> produits  = new ArrayList<>();
        for (ProduitEntity produitEntity : produitEntities) {
            Produit produit = new Produit();
            produit.setId(produitEntity.getId());
            produit.setNom(produitEntity.getNom());
            produit.setPrix(produitEntity.getPrix());
            produit.setQuantite(produitEntity.getQuantite());
            produits.add(produit);
        }
        return new ResponseEntity<List<Produit>>(produits,HttpStatus.OK);
    }*/

}

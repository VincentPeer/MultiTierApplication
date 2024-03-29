package ch.heig.amt.exa.PEER.api.endpoints;

import ch.heig.amt.exa.PEER.api.entities.ProduitEntity;
import ch.heig.amt.exa.PEER.api.entities.VilleEntity;
import ch.heig.amt.exa.PEER.api.exceptions.ProduitNotFoundException;
import ch.heig.amt.exa.PEER.api.repositories.ProduitRepository;
import org.openapitools.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.openapitools.api.ProduitsApi;

import java.util.Optional;

@RestController
public class ProduitsEndPoint implements ProduitsApi {

    @Autowired
    private ProduitRepository produitsRepository;


    @Override
    public ResponseEntity<Produit> getProduit(Integer id) {
        Optional<ProduitEntity> opt = produitsRepository.findById(id);
        if(opt.isPresent()) {
            ProduitEntity produitEntity = opt.get();
            Produit produit = new Produit();
            produit.setNumero(produitEntity.getPrd_num());
            produit.setDescription(produitEntity.getDescription());
            produit.setPoids(produitEntity.getPoids());
            produit.setStatusLivraison(produitEntity.getStatus_livraison());
            produit.setVille(produitEntity.getVille().getId());
            return new ResponseEntity<Produit>(produit, HttpStatus.OK);
        } else {
            throw new ProduitNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<Void> addProduit(Produit produit) {
        ProduitEntity produitEntity = new ProduitEntity();
        produitEntity.setPrd_num(produit.getNumero());
        produitEntity.setDescription(produit.getDescription());
        produitEntity.setPoids(produit.getPoids());
        produitEntity.setStatus_livraison(produit.getStatusLivraison().toString());
        produitEntity.setVille(new VilleEntity()); // TODO: get ville from id
        produitsRepository.save(produitEntity);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}

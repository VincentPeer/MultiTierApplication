package ch.heig.amt.exa.PEER.api.exceptions;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(Integer id) {
        super("Produit " + id + " non trouvé");
    }

}

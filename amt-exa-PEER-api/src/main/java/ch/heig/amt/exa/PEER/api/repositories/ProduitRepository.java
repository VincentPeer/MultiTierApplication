package ch.heig.amt.exa.PEER.api.repositories;

import ch.heig.amt.exa.PEER.api.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Integer> {
    ProduitEntity findById(int id);

}

package ch.heig.amt.exa.PEER.api.repositories;

import ch.heig.amt.exa.PEER.api.entities.VilleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VilleRepository extends JpaRepository<VilleEntity, Integer> {
    VilleEntity findById(int id);
    List<VilleEntity> findByNomLike(String pattern);
}

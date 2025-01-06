package elhou.salima.agencebancaireservice.repository;

import elhou.salima.agencebancaireservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
}


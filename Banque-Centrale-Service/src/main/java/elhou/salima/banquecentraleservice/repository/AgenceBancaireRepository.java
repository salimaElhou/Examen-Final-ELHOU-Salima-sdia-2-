package elhou.salima.banquecentraleservice.repository;

import elhou.salima.banquecentraleservice.entities.AgenceBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceBancaireRepository extends JpaRepository<AgenceBancaire,String> {
}

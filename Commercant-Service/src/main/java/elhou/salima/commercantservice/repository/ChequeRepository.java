package elhou.salima.commercantservice.repository;

import elhou.salima.commercantservice.entities.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Long> {
    Optional<Cheque> findByNumero(String numero);
}

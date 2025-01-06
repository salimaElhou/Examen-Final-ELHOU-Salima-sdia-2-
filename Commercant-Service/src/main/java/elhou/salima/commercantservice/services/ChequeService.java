package elhou.salima.commercantservice.services;

import elhou.salima.commercantservice.entities.Cheque;
import elhou.salima.commercantservice.repository.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChequeService {
    @Autowired
    private ChequeRepository chequeRepository;

    public List<Cheque> getAllCheques() {
        return chequeRepository.findAll();
    }

    public Cheque saveCheque(Cheque cheque) {
        return chequeRepository.save(cheque);
    }

    public Optional<Cheque> findByNumero(String numero) {
        return chequeRepository.findByNumero(numero);
    }
}


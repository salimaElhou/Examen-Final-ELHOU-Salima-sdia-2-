package elhou.salima.agencebancaireservice.service;

import elhou.salima.agencebancaireservice.entities.Compte;
import elhou.salima.agencebancaireservice.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Optional<Compte> getCompteByNumero(String numero) {
        return compteRepository.findById(numero);
    }

    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte updateSolde(String numero, Double montant) {
        Optional<Compte> compte = compteRepository.findById(numero);
        if (compte.isPresent()) {
            Compte updatedCompte = compte.get();
            updatedCompte.setSolde(updatedCompte.getSolde() + montant);
            return compteRepository.save(updatedCompte);
        }
        throw new RuntimeException("Compte introuvable");
    }
}



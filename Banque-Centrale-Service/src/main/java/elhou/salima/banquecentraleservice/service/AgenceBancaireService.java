package elhou.salima.banquecentraleservice.service;

import elhou.salima.banquecentraleservice.entities.AgenceBancaire;
import elhou.salima.banquecentraleservice.repository.AgenceBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceBancaireService {
    @Autowired
    private AgenceBancaireRepository agenceBancaireRepository;

    public List<AgenceBancaire> getAllAgences() {
        return agenceBancaireRepository.findAll();
    }

    public AgenceBancaire saveAgence(AgenceBancaire agence) {
        return agenceBancaireRepository.save(agence);
    }
}


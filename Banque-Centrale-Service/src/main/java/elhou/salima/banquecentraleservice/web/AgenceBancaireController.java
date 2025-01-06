package elhou.salima.banquecentraleservice.web;


import elhou.salima.banquecentraleservice.entities.AgenceBancaire;
import elhou.salima.banquecentraleservice.service.AgenceBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceBancaireController {
    @Autowired
    private AgenceBancaireService agenceBancaireService;

    @GetMapping
    public List<AgenceBancaire> getAllAgences() {
        return agenceBancaireService.getAllAgences();
    }

    @PostMapping
    public AgenceBancaire saveAgence(@RequestBody AgenceBancaire agence) {
        return agenceBancaireService.saveAgence(agence);
    }
}

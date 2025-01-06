package elhou.salima.agencebancaireservice.web;


import elhou.salima.agencebancaireservice.entities.Compte;
import elhou.salima.agencebancaireservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Compte> getCompteByNumero(@PathVariable String numero) {
        return compteService.getCompteByNumero(numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Compte saveCompte(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }

    @PutMapping("/{numero}/update-solde")
    public ResponseEntity<Compte> updateSolde(@PathVariable String numero, @RequestBody Double montant) {
        try {
            return ResponseEntity.ok(compteService.updateSolde(numero, montant));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

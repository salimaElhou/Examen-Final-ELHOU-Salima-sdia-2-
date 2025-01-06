package elhou.salima.commercantservice.web;

import elhou.salima.commercantservice.entities.Cheque;

import elhou.salima.commercantservice.services.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cheques")
public class ChequeController {
    @Autowired
    private ChequeService chequeService;

    @GetMapping
    public List<Cheque> getAllCheques() {
        return chequeService.getAllCheques();
    }

    @PostMapping
    public Cheque saveCheque(@RequestBody Cheque cheque) {
        return chequeService.saveCheque(cheque);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Cheque> getChequeByNumero(@PathVariable String numero) {
        return chequeService.findByNumero(numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


package elhou.salima.agencebancaireservice.entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Data

public class Compte {
    @Id
    private String numero;
    private Double solde;
    private String type; // COURANT, EPARGNE
    private String proprietaire; // Nom du client
}




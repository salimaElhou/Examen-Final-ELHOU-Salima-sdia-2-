package elhou.salima.agencebancaireservice;

import elhou.salima.agencebancaireservice.entities.Compte;
import elhou.salima.agencebancaireservice.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgenceBancaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgenceBancaireServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CompteRepository compteRepository) {
        return args -> {
            // Création de comptes avec le builder
            compteRepository.save(Compte.builder()
                    .numero("123456")
                    .solde(1500.0)
                    .type("COURANT")
                    .proprietaire("John Doe")
                    .build());

            compteRepository.save(Compte.builder()
                    .numero("789012")
                    .solde(2500.0)
                    .type("EPARGNE")
                    .proprietaire("Jane Smith")
                    .build());

            compteRepository.save(Compte.builder()
                    .numero("345678")
                    .solde(3000.0)
                    .type("COURANT")
                    .proprietaire("Alice Brown")
                    .build());
        };
    }
}

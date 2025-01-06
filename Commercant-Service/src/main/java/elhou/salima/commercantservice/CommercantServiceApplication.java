package elhou.salima.commercantservice;

import elhou.salima.commercantservice.entities.Cheque;
import elhou.salima.commercantservice.repository.ChequeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommercantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommercantServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ChequeRepository chequeRepository) {
        return args -> {
            // Utilisation du Builder pour créer des objets Cheque
            chequeRepository.save(Cheque.builder()
                    .numero("CH12345")
                    .codeBanque("BANK001")
                    .numeroCompte("ACC789")
                    .nomClient("John Doe")
                    .montant(1500.0)
                    .certifie(true)
                    .build());

            chequeRepository.save(Cheque.builder()
                    .numero("CH67890")
                    .codeBanque("BANK002")
                    .numeroCompte("ACC456")
                    .nomClient("Jane Smith")
                    .montant(3000.0)
                    .certifie(false)
                    .build());

            chequeRepository.save(Cheque.builder()
                    .numero("CH11223")
                    .codeBanque("BANK003")
                    .numeroCompte("ACC123")
                    .nomClient("Alice Brown")
                    .montant(500.0)
                    .certifie(true)
                    .build());
        };
    }
}

package elhou.salima.banquecentraleservice;

import elhou.salima.banquecentraleservice.entities.AgenceBancaire;
import elhou.salima.banquecentraleservice.repository.AgenceBancaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
@EnableFeignClients
public class BanqueCentraleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueCentraleServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AgenceBancaireRepository agenceBancaireRepository) {
        return args -> {
            List<String> agenceNames = List.of("Agence A", "Agence B", "Agence C");
            List<String> cities = List.of("Casablanca", "Rabat", "Marrakech");
            List<String> urls = List.of("http://serviceA.com", "http://serviceB.com", "http://serviceC.com");

            for (int i = 0; i < 3; i++) {
                AgenceBancaire agenceBancaire = AgenceBancaire.builder()
                        .nom(agenceNames.get(i))
                        .ville(cities.get(i))
                        .urlWebService(urls.get(i))
                        .build();

                agenceBancaireRepository.save(agenceBancaire);
            }
        };
    }


}

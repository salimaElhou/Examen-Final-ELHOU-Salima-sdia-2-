package elhou.salima.inventoryservice;

import elhou.salima.inventoryservice.entities.Product;
import elhou.salima.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;



//app = main + TEST -> Bean

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .id("P01")
                    .name("Computer")
                    .quantity(12)
                    .price(4300)
                    .build());
            productRepository.save(Product.builder()
                    .id("P02")
                    .name("Phone")
                    .quantity(11)
                    .price(12000)
                    .build());
            productRepository.save(Product.builder()
                    .id("P03")
                    .name("Printer")
                    .quantity(3)
                    .price(1200)
                    .build());
        };
    }
}

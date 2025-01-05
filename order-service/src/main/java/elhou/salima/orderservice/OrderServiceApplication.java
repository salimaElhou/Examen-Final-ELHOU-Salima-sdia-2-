package elhou.salima.orderservice;

import elhou.salima.orderservice.entities.Order;
import elhou.salima.orderservice.entities.OrderState;
import elhou.salima.orderservice.entities.ProductItem;
import elhou.salima.orderservice.model.Product;
import elhou.salima.orderservice.repository.OrderRepository;
import elhou.salima.orderservice.repository.ProductItemRepository;
import elhou.salima.orderservice.restClients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            InventoryRestClient inventoryRestClient){
        return args -> {

            //List<Product> allProducts = inventoryRestClient.getAllProducts();

            List<String> productsIds = List.of("P01","P02","P03");
            for (int i = 0; i < 5; i++) {
                    Order order=Order.builder()
                            .id(UUID.randomUUID().toString())
                            .date(LocalDate.now())
                            .state(OrderState.PENDING)
                            .build();
                Order savedOrder = orderRepository.save(order);

                productsIds.forEach(pId->{
                    //System.out.println(p.getName());
                    ProductItem productItem = ProductItem.builder()
                            .productId(pId)
                            .quantity(new Random().nextInt(20))
                            .order(savedOrder)
                            .price(Math.random()*60000+3000)
                            .build();

                    productItemRepository.save(productItem);
                });
            }


        };
    }

}

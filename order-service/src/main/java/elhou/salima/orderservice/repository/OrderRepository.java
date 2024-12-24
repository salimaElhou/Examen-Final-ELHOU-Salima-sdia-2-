package elhou.salima.orderservice.repository;

import elhou.salima.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}

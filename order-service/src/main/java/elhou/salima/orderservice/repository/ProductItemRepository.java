package elhou.salima.orderservice.repository;

import elhou.salima.orderservice.entities.Order;
import elhou.salima.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}

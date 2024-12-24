package elhou.salima.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "orders") // ou un autre nom non réservé
public class Order {
    @Id
    private String id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private OrderState state;

    //chaque order possede List de products
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

}

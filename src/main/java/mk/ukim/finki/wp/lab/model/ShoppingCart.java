package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
    private LocalDateTime dateCreated;
    private List<Order> orders;

    public ShoppingCart(User user, LocalDateTime dateCreated, List<Order> orders) {
        this.user = user;
        this.dateCreated = dateCreated;
        this.orders = orders;
    }
}

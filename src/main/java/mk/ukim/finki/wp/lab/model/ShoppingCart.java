package mk.ukim.finki.wp.lab.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
    private LocalDateTime dateCreated;

    @ManyToMany
    private List<Order> orders;

    public ShoppingCart(User user, LocalDateTime dateCreated, List<Order> orders) {
        this.user = user;
        this.dateCreated = dateCreated;
        this.orders = orders;
    }
}

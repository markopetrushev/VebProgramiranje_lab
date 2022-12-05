package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Order {

    private Long orderId;

    private String balloonColor;

    private String balloonSize;

    public Order(Long orderId, String balloonColor, String balloonSize) {
        this.orderId = orderId;
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
    }
}

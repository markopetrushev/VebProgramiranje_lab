package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Order {

    private Long orderId;

    private String balloonColor;

    private String balloonSize;

    private String clientName;

    private String clientAddress;

    public Order(Long orderId, String balloonColor, String balloonSize, String clientName, String clientAddress) {
        this.orderId = orderId;
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }
}

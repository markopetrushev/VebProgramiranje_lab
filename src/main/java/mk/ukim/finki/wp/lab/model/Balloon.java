package mk.ukim.finki.wp.lab.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balloon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private Manufacturer manufacturer;

    public Balloon(Long id, String name, String description, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }
}

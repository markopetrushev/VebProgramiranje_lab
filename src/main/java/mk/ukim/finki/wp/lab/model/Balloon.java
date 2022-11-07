package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Balloon {

    private Long id;
    private String name;
    private String description;
    private Manufacturer manufacturer;

    public Balloon(Long id, String name, String description, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }
}

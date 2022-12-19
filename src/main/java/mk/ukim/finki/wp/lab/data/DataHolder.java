package mk.ukim.finki.wp.lab.data;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init() {
        balloons.add(new Balloon("Danger", "red", new Manufacturer(1L, "Bloon Industries", "USA", "4390 Emily Renzelli Boulevard")));
        balloons.add(new Balloon("Caution", "yellow", new Manufacturer(2L, "Balloon Bonanza", "Kazakhstan", "Balykshy / Ul. Abay Kunanbaev (Aktobe), bld. 26")));
        balloons.add(new Balloon("Eco", "green", new Manufacturer(3L, "Helium Heaven", "Germany", " Augsburger Straße 21")));
        balloons.add(new Balloon("Fun", "blue", new Manufacturer(4L, "The Balloon Express", "Japan", "226-1181, Omagari Marukocho")));
        balloons.add(new Balloon("UltraFun", "cyan", new Manufacturer(5L, "BLoON Central", "Macedonia", "Leninova 29, Skopje 1000")));

        manufacturers.add(new Manufacturer(1L, "Bloon Industries", "USA", "4390 Emily Renzelli Boulevard"));
        manufacturers.add(new Manufacturer(2L, "Balloon Bonanza", "Kazakhstan", "Balykshy / Ul. Abay Kunanbaev (Aktobe), bld. 26"));
        manufacturers.add(new Manufacturer(3L, "Helium Heaven", "Germany", " Augsburger Straße 21"));
        manufacturers.add(new Manufacturer(4L, "The Balloon Express", "Japan", "226-1181, Omagari Marukocho"));
        manufacturers.add(new Manufacturer(5L, "BLoON Central", "Macedonia", "Leninova 29, Skopje 1000"));

    }

    public static Long generateId () {
        Random rand = new Random();

        long id = rand.nextLong(10000);

        for (Balloon bloon : balloons) {
            if (bloon.getId() == id)
                generateId();
        }
        return id;
    }
}

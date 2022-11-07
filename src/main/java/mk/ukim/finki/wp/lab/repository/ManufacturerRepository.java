package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.data.DataHolder;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll() {
        return DataHolder.manufacturers;
    }

    public Manufacturer findManufacturer(Long id) {
        return DataHolder.manufacturers
                .stream()
                .filter(manufacturer -> manufacturer.getId().equals(id))
                .findFirst()
                .get();
    }
}

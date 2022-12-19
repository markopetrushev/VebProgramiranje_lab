package mk.ukim.finki.wp.lab.repository.jpaRepository;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {

    List<Balloon> findAll();
    List<Balloon> findAllByNameOrDescriptionLike(String text1, String text2);
    Optional<Balloon> findByName(String name);
    void deleteByName(String name);
}

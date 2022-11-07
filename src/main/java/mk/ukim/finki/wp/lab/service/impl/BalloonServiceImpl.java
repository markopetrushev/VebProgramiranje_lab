package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        if(text.isEmpty()) {
            throw new NullPointerException();
        }
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        if(id == null)
            throw new IllegalArgumentException();
        return balloonRepository.findById(id);
    }

    @Override
    public void createBalloon(String name, String description, Manufacturer manufacturer) {
        if(name == null || description == null || manufacturer == null)
            throw new IllegalArgumentException();
        balloonRepository.createBalloon(name,description,manufacturer);
    }

    @Override
    public void deleteById(Long id) {
        if(id == null)
            throw new IllegalArgumentException();
        balloonRepository.deleteById(id);
    }
}

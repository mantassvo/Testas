package lt.codeacademy.carrental.services;

import lt.codeacademy.carrental.entities.CarOwner;
import lt.codeacademy.carrental.repositories.CarOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarOwningService {

    private CarOwnerRepository carOwnerRepository;

    public CarOwningService(CarOwnerRepository carOwnerRepository) {
        this.carOwnerRepository = carOwnerRepository;
    }

    public List<CarOwner> getAllCarOwners() {
        return this.carOwnerRepository.findAll();
    }


    public CarOwner getOwnerById(Long id) {
        Optional<CarOwner> owner = this.carOwnerRepository.findById(id);
        if (owner.isPresent()) {
            return owner.get();
        } else {
            return null;
        }
    }

    public void deleteOwnerById(Long id) {
        this.carOwnerRepository.deleteById(id);
    }

    public void saveCarOwner(CarOwner carOwner) {
        this.carOwnerRepository.save(carOwner);
    }

}

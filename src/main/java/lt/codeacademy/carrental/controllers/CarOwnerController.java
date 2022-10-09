package lt.codeacademy.carrental.controllers;


import lt.codeacademy.carrental.dto.GetCarOwnerResponseDTO;
import lt.codeacademy.carrental.dto.CreateCarOwnerRequestDTO;
import lt.codeacademy.carrental.entities.CarOwner;
import lt.codeacademy.carrental.services.CarOwningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lt.codeacademy.carrental.converter.CarOwnerConverter.*;

@CrossOrigin
@RestController
@RequestMapping("/car-owner")
public class CarOwnerController {

    @Autowired
    private CarOwningService carOwningService;

    @GetMapping
    public List<CarOwner> getAllCarOwners() {
        return carOwningService.getAllCarOwners();
    }

    @PostMapping
    public void createCarOwner(@RequestBody CreateCarOwnerRequestDTO createCarOwnerRequestDTO) {
        CarOwner carOwner = convertCreateCarOwnerRequestDtoToCarOwner(createCarOwnerRequestDTO);
        this.carOwningService.saveCarOwner(carOwner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putOwnerById(@PathVariable(name = "id") Long id,
                                             @RequestBody CreateCarOwnerRequestDTO requestDTO) {
        CarOwner owner = this.carOwningService.getOwnerById(id);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CarOwner newOwner = convertCreateCarOwnerRequestDtoToCarOwner(requestDTO);
        newOwner.setId(owner.getId());
        this.carOwningService.saveCarOwner(newOwner);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchOwnerById(@PathVariable(name = "id") Long id,
                                               @RequestBody CreateCarOwnerRequestDTO requestDTO) {
        CarOwner owner = this.carOwningService.getOwnerById(id);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        patchCarOwnerFromCreateCarOwnerRequestDto(owner, requestDTO);
        this.carOwningService.saveCarOwner(owner);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCarOwnerResponseDTO> getOwnerById(@PathVariable(name = "id") Long id) {
        CarOwner owner = this.carOwningService.getOwnerById(id);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(convertCarOwnerToGetCarOwnerResponseDto(owner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwnerById(@PathVariable(name = "id") Long id) {
        this.carOwningService.deleteOwnerById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/company")
    public ResponseEntity<String> getOwnersCompanyNameById(@PathVariable(name = "id") Long id) {
        CarOwner owner = this.carOwningService.getOwnerById(id);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(convertCarOwnerToGetCarOwnerResponseDto(owner).getCompanyName());
    }


}

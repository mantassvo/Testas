package lt.codeacademy.carrental.converter;

import lt.codeacademy.carrental.dto.CreateCarOwnerRequestDTO;
import lt.codeacademy.carrental.dto.GetCarOwnerResponseDTO;
import lt.codeacademy.carrental.entities.CarOwner;

public class CarOwnerConverter {

    public static GetCarOwnerResponseDTO convertCarOwnerToGetCarOwnerResponseDto(CarOwner carOwner) {
        GetCarOwnerResponseDTO carOwnerDTO = null;
        if (carOwner != null) {
            carOwnerDTO = new GetCarOwnerResponseDTO();
            carOwnerDTO.setAddress(carOwner.getAddress());
            carOwnerDTO.setId(carOwner.getId());
            carOwnerDTO.setCompanyName(carOwner.getCompanyName());
            carOwnerDTO.setPhoneNo(carOwner.getPhoneNo());
        }
        return carOwnerDTO;
    }

    public static CarOwner convertCreateCarOwnerRequestDtoToCarOwner(CreateCarOwnerRequestDTO requestDTO) {
        CarOwner carOwner = null;
        if (requestDTO != null) {
            carOwner = new CarOwner();
            carOwner.setCompanyName(requestDTO.getCompanyName());
            carOwner.setPhoneNo(requestDTO.getPhoneNo());
            carOwner.setAddress(requestDTO.getAddress());
        }
        return carOwner;
    }

    public static CarOwner patchCarOwnerFromCreateCarOwnerRequestDto(CarOwner carOwner,
                                                                     CreateCarOwnerRequestDTO requestDTO) {
        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getAddress(), carOwner.getAddress())) {
            carOwner.setAddress(requestDTO.getAddress());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getCompanyName(), carOwner.getCompanyName())) {
            carOwner.setCompanyName(requestDTO.getCompanyName());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getPhoneNo(), carOwner.getPhoneNo())) {
            carOwner.setPhoneNo(requestDTO.getPhoneNo());
        }

        return carOwner;
    }

    private static boolean isNewStringValueEmptyNullOrSameAsOld(String newValue, String oldValue){
        return newValue != null && !newValue.isEmpty() && !newValue.equals(oldValue);
    }
}

package lt.codeacademy.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetCarOwnerResponseDTO {

    private Long id;
    private String companyName;
    private String address;
    private String phoneNo;

}

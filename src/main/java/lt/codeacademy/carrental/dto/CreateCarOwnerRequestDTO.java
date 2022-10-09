package lt.codeacademy.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCarOwnerRequestDTO {

    private String companyName;
    private String address;
    private String phoneNo;

    @Override
    public String toString() {
        return "SaveCarOwnerRequestDTO{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}


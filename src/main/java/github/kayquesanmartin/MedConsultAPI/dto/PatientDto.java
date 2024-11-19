package github.kayquesanmartin.MedConsultAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;
    private String cpf;
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String gender;
    private LocalDate birthDate;
    private String address;

}

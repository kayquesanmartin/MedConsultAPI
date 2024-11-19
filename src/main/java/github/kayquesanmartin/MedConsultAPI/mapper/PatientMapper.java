package github.kayquesanmartin.MedConsultAPI.mapper;

import github.kayquesanmartin.MedConsultAPI.dto.PatientDto;
import github.kayquesanmartin.MedConsultAPI.entity.Patient;

public class PatientMapper {

    // Converte um objeto Patient (entidade) para PatientDto (transfer object)
    public static PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getCpf(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getTelephoneNumber(),
                patient.getGender(),
                patient.getBirthDate(),
                patient.getAddress()
        );
    }

    // Converte um objeto PatientDto (transfer object) para Patient (entidade)
    public static Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getCpf(),
                patientDto.getFirstName(),
                patientDto.getLastName(),
                patientDto.getEmail(),
                patientDto.getTelephoneNumber(),
                patientDto.getGender(),
                patientDto.getBirthDate(),
                patientDto.getAddress()
        );
    }
}

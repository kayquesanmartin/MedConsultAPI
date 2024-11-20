package github.kayquesanmartin.MedConsultAPI.service;

import github.kayquesanmartin.MedConsultAPI.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto createPatient(PatientDto patientDto);

    PatientDto getPatientById(Long patientId);

    List<PatientDto> getAllPatients();

    PatientDto updatePatient(Long patientId, PatientDto patientDto);
}

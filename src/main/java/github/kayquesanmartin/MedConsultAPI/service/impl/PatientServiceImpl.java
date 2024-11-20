package github.kayquesanmartin.MedConsultAPI.service.impl;

import github.kayquesanmartin.MedConsultAPI.dto.PatientDto;
import github.kayquesanmartin.MedConsultAPI.entity.Patient;
import github.kayquesanmartin.MedConsultAPI.exception.ResourceNotFoundException;
import github.kayquesanmartin.MedConsultAPI.mapper.PatientMapper;
import github.kayquesanmartin.MedConsultAPI.repository.PatientRepository;
import github.kayquesanmartin.MedConsultAPI.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {

        // Convertendo o DTO para Entidade
        Patient patient = PatientMapper.mapToPatient(patientDto);

        // Salvando no banco de dados (usando o repository)
        Patient savedPatient = patientRepository.save(patient);

        // Convertendo a entidade salva de volta para DTO
        return PatientMapper.mapToPatientDto(savedPatient);
    }

    @Override
    public PatientDto getPatientById(Long patientId) {

        Patient patient = patientRepository.findById(patientId)
                . orElseThrow(
                        () -> new ResourceNotFoundException("Patient with id " + patientId + " not found")
                );

        return PatientMapper.mapToPatientDto(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {

        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(patient -> PatientMapper.mapToPatientDto(patient))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(Long patientId, PatientDto updatedPatient) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient is not exists with given id: " + patientId)
                );

        patient.setCpf(updatedPatient.getCpf());
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setEmail(updatedPatient.getEmail());
        patient.setTelephoneNumber(updatedPatient.getTelephoneNumber());
        patient.setGender(updatedPatient.getGender());
        patient.setBirthDate(updatedPatient.getBirthDate());
        patient.setAddress(updatedPatient.getAddress());

        Patient updatedPatientObj = patientRepository.save(patient);

        return PatientMapper.mapToPatientDto(updatedPatientObj);
    }
}

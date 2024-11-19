package github.kayquesanmartin.MedConsultAPI.service.impl;

import github.kayquesanmartin.MedConsultAPI.dto.PatientDto;
import github.kayquesanmartin.MedConsultAPI.entity.Patient;
import github.kayquesanmartin.MedConsultAPI.mapper.PatientMapper;
import github.kayquesanmartin.MedConsultAPI.repository.PatientRepository;
import github.kayquesanmartin.MedConsultAPI.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}

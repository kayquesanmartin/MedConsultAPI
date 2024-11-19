package github.kayquesanmartin.MedConsultAPI.controller;

import github.kayquesanmartin.MedConsultAPI.dto.PatientDto;
import github.kayquesanmartin.MedConsultAPI.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // Build Add Patient REST API
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(
            @RequestBody PatientDto patientDto) {

        PatientDto savedPatient = patientService.createPatient(patientDto);

        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);

    }

    // Build Get Patient REST API
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long patientId) {
        PatientDto patientDto = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patientDto);
    }

    // Build Get All Patients REST API
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> patients = patientService.getAllPatients();

        return ResponseEntity.ok(patients);
    }
}

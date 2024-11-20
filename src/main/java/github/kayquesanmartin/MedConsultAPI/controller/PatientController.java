package github.kayquesanmartin.MedConsultAPI.controller;

import github.kayquesanmartin.MedConsultAPI.dto.PatientDto;
import github.kayquesanmartin.MedConsultAPI.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
@Tag(name = "Patient")
public class PatientController {

    private final PatientService patientService;

    @Operation(description = "Operação para criar um paciente.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {

        PatientDto savedPatient = patientService.createPatient(patientDto);

        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);

    }

    @Operation(description = "Operação para buscar um paciente pelo ID.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ficha de paciente encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ficha de paciente não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long patientId) {
        PatientDto patientDto = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patientDto);
    }

    @Operation(description = "Operação para buscar todos os pacientes.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fichas dos pacientes encontradas com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> patients = patientService.getAllPatients();

        return ResponseEntity.ok(patients);
    }

    @Operation(description = "Operação para atualizar um paciente pelo ID.", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ficha de paciente atualizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long patientId, @RequestBody PatientDto updatePatient){
        PatientDto patientDto = patientService.updatePatient(patientId, updatePatient);

        return ResponseEntity.ok(patientDto);
    }

    @Operation(description = "Operação para deletar um paciente pelo ID.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ficha de paciente deletada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long patientId){

        patientService.deletePatient(patientId);

        return ResponseEntity.ok("Patient deleted succesfully");
    }
}

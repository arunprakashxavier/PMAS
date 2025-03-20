package com.project.pmas.service;

import com.project.pmas.dto.PatientDto;
import com.project.pmas.dto.save.SavePatientDto;

import java.util.List;

public interface PatientService{

    List<PatientDto> getAllPatients();

    PatientDto getPatientById(Long id);

    PatientDto getPatientByUsername(String username);

    String getPatientFirstnameByUsername(String username);

    PatientDto addPatient(SavePatientDto savePatientDto);

    PatientDto updatePatient(Long id, SavePatientDto savePatientDto);

    void deletePatientById(Long id);
}

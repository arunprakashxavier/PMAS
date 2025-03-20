package com.project.pmas.service;

import com.project.pmas.dto.save.SaveDoctorDto;
import com.project.pmas.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(Long id);

    DoctorDto addDoctor(SaveDoctorDto saveDoctorDto);

    List<DoctorDto> addAllDoctors(List<SaveDoctorDto> saveDoctorDtoList);

    DoctorDto updateDoctor(Long id, SaveDoctorDto saveDoctorDto);

    void deleteDoctorById(Long id);
}

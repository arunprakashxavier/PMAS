package com.project.pmas.service;

import com.project.pmas.dto.AppointmentDto;
import com.project.pmas.dto.DoctorDto;
import com.project.pmas.dto.SlotDto;
import com.project.pmas.dto.save.SaveAppointmentDto;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentById(Long id);

    AppointmentDto createAppointment(SaveAppointmentDto saveAppointmentDto);

    String deleteAppointment(Long id);

    boolean existsByDoctorId(Long doctorId);

    void deleteAllAppointmentByDoctorId(Long doctorId);

    boolean existsByPatientId(Long id);

    void deleteAllAppointmentByPatientId(Long id);

    List<List<AppointmentDto>> getAllAppointmentByUsername(String name);

    List<DoctorDto> getDoctorsBySpeciality(String specialty);

    List<String> getAllDoctorSpecialties();
    List<SlotDto> getAvailableSlots(Long doctorId, String date);

    Long getPatientIdByUsername(String name);
}

package com.project.pmas.mapper;

import com.project.pmas.dto.save.SaveDoctorDto;
import com.project.pmas.dto.DoctorDto;
import com.project.pmas.model.Doctor;

public class DoctorMapper {
    public static DoctorDto mapToDoctorDto(Doctor doctor){
        return new DoctorDto(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getGender(),
                doctor.getMobile(),
                doctor.getEmail(),
                doctor.getSpeciality(),
                doctor.getExperienceInYears(),
                doctor.getQualifications(),
                doctor.getLanguagesSpoken(),
                doctor.getOfficeAddress()
        );
    }

    public static Doctor mapToDoctor(DoctorDto doctorDto){
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getFirstName().trim(),
                doctorDto.getLastName().trim(),
                doctorDto.getGender().trim(),
                doctorDto.getMobile().trim(),
                doctorDto.getEmail().trim(),
                doctorDto.getSpeciality().trim(),
                doctorDto.getExperienceInYears(),
                doctorDto.getQualifications().trim(),
                doctorDto.getLanguagesSpoken().trim(),
                doctorDto.getOfficeAddress().trim()
        );
    }

    public static Doctor mapToDoctorFromSaveDoctorDto(Long id, SaveDoctorDto saveDoctorDto){
        return new Doctor(
                id,
                saveDoctorDto.getFirstName().trim(),
                saveDoctorDto.getLastName().trim(),
                saveDoctorDto.getGender().trim(),
                saveDoctorDto.getMobile().trim(),
                saveDoctorDto.getEmail().trim(),
                saveDoctorDto.getSpeciality().trim(),
                saveDoctorDto.getExperienceInYears(),
                saveDoctorDto.getQualifications().trim(),
                saveDoctorDto.getLanguagesSpoken().trim(),
                saveDoctorDto.getOfficeAddress().trim()
        );
    }
}

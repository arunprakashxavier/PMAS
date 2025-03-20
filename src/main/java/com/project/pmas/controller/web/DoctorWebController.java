package com.project.pmas.controller.web;

import com.project.pmas.dto.save.SaveDoctorDto;
import com.project.pmas.service.DoctorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/web/doctors")
@AllArgsConstructor
public class DoctorWebController {
    private DoctorService doctorService;

    /**
     * A mvc method for the sign-up/register page
     * @param model
     * @return the doctor-registration page
     */
    // http://localhost:8082/web/doctors/register
    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("newDoctor", new SaveDoctorDto());
        return "doctor-register";
    }

    /**
     * A mvc method saving the doctor.
     * @param model
     * @param saveDoctorDto Doctor object with necessary details.
     * @return success or error page based on the outcome.
     */
    @PostMapping(value = "/saveDoctor")
    public String register(Model model, @Valid @ModelAttribute SaveDoctorDto saveDoctorDto) {
//        System.out.println(saveDoctorDto.toString());
        try{
            doctorService.addDoctor(saveDoctorDto);
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
            return "redirect:/web/doctors/register?mobileAlreadyExists";
        }
        return "redirect:/web/doctors/register?success";
    }
}

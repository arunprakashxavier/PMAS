package com.project.pmas.controller.web;

import com.project.pmas.dto.PatientDto;
import com.project.pmas.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
@RequestMapping(value = "/web/patients")
@AllArgsConstructor
public class PatientWebController {
    private PatientService patientService;

    /**
     * A mvc method for rendering the home page
     *
     * @param model Model interface object,
     * @param authentication Authentication interface object.
     * @return Patient home page or error page based on the outcome.
     */
    // http://localhost:8082/web/patients/home
    @GetMapping(value = "/home")
    public String goHome(Model model, Authentication authentication) {
        System.out.println("Rendering patient homepage...");
        String patientName = "";
        try{
            patientName = patientService.getPatientFirstnameByUsername(authentication.getName());
        } catch(NoSuchElementException exception){
            String message = exception.getMessage();

            model.addAttribute("message", message);
            return "error";
        }
        model.addAttribute("patientName", patientName);
        return "home";
    }

    /**
     * A mvc method for showing the profile page
     *
     * @param model Model interface object,
     * @param authentication Authentication interface object.
     * @return Patient's profile page.
     */
    // http://localhost:8082/web/patients/profile
    @GetMapping(value = "/profile")
    public String getProfile(Model model, Authentication authentication) {
        PatientDto patientDto = patientService.getPatientByUsername(authentication.getName());
        model.addAttribute("patient", patientDto);
        return "profile/profile";
    }

    /**
     * A mvc method for the logout confirmation page
     *
     * @return Logout confirmation view.
     */
    // http://localhost:8082/web/patients/confirm-logout
    @GetMapping(value = "/confirm-logout")
    public String confirmLogout() {
        return "confirm-logout";
    }
}

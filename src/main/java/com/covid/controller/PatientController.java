package com.covid.controller;

import com.covid.model.Patient;
import com.covid.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/home")
    public String saveData() {
        return "homePage";
    }

    @PostMapping("/saveData")
    public String saveData(@RequestParam(name = "name") String patientName, @RequestParam(name = "notes", required = false, defaultValue = "") String notes, Model model, RedirectAttributes redirectAttributes) {

        Patient patient = new Patient();
        patient.setNotes(notes);
        patient.setName(patientName);
        patientService.savePatientData(patient);
        redirectAttributes.addFlashAttribute("message", "Saved Successfully!");

        return "redirect:/home";
    }

}

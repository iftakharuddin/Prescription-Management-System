package com.iftakhar.prescription.controller;

import com.iftakhar.prescription.entity.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.iftakhar.prescription.dto.PrescriptionDTO;
import com.iftakhar.prescription.repository.*;
import com.iftakhar.prescription.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {
    private final PrescriptionService service;
    private final UserRepository userRepo;
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionController(PrescriptionService service, UserRepository userRepo, PrescriptionRepository prescriptionRepository) {
        this.service = service;
        this.userRepo = userRepo;
        this.prescriptionRepository = prescriptionRepository;
    }

    @GetMapping
    public String listPrescriptions(@AuthenticationPrincipal User user, Model model, 
                @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from, 
                @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

        LocalDate now = LocalDate.now();
        if (from == null) from = now.withDayOfMonth(1);
        if (to == null) to = now.withDayOfMonth(now.lengthOfMonth());
        model.addAttribute("from", from);
        model.addAttribute("to", to);

        List<Prescription> prescriptions = prescriptionRepository.findByUserAndPrescriptionDateBetween(user, from, to);
        model.addAttribute("prescriptions", prescriptions);
        return "prescriptions/list";
    }


    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("prescriptionDTO", new PrescriptionDTO());
        return "prescriptions/form";
    }

    // @PostMapping
    // public String save(@Valid @ModelAttribute PrescriptionDTO dto, BindingResult br, Principal principal) {
    //     if (br.hasErrors()) return "prescriptions/form";
    //     Prescription p = new Prescription();
    //     p.setPrescriptionDate(dto.getPrescriptionDate());
    //     p.setPatientName(dto.getPatientName());
    //     p.setPatientAge(dto.getPatientAge());
    //     p.setPatientGender(dto.getPatientGender());
    //     p.setDiagnosis(dto.getDiagnosis());
    //     p.setMedicines(dto.getMedicines());
    //     p.setNextVisitDate(dto.getNextVisitDate());
    //     p.setCreatedBy(userRepo.findByUsername(principal.getName()).orElse(null));
    //     service.save(p);
    //     return "redirect:/prescriptions";
    // }

    @PostMapping
    public String savePrescription(@AuthenticationPrincipal User user, @ModelAttribute Prescription prescription, BindingResult br) {
        if (br.hasErrors()) return "prescriptions/form";
        prescription.setUser(user);
        prescriptionRepository.save(prescription);
        return "redirect:/prescriptions";
    }   


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/prescriptions";
    }

    @GetMapping("/view/{id}")
    public String viewPrescription(@PathVariable("id") Long id, Model model) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid prescription Id: " + id));

        model.addAttribute("prescription", prescription);
        return "prescriptions/view";
    }

    @GetMapping("/edit/{id}")
    public String editPrescriptionForm(@PathVariable("id") Long id, Model model) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid prescription Id: " + id));

        model.addAttribute("prescription", prescription);
        return "prescriptions/edit";
    }

    @PostMapping("/update/{id}")
    public String updatePrescription(@PathVariable("id") Long id, @ModelAttribute("prescription") Prescription updatedPrescription) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid prescription Id: " + id));

        // Update all editable fields
        prescription.setPrescriptionDate(updatedPrescription.getPrescriptionDate());
        prescription.setPatientName(updatedPrescription.getPatientName());
        prescription.setPatientAge(updatedPrescription.getPatientAge());
        prescription.setPatientGender(updatedPrescription.getPatientGender());
        prescription.setDiagnosis(updatedPrescription.getDiagnosis());
        prescription.setMedicines(updatedPrescription.getMedicines());
        prescription.setNextVisitDate(updatedPrescription.getNextVisitDate());

        prescriptionRepository.save(prescription);
        return "redirect:/prescriptions";
    }

}

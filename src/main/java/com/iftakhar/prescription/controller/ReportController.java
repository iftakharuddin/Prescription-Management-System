package com.iftakhar.prescription.controller;

import com.iftakhar.prescription.service.PrescriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
    private final PrescriptionService service;
    public ReportController(PrescriptionService service){this.service=service;}

    @GetMapping("/reports/daily")
    public String daily(Model model){
        model.addAttribute("dayCounts", service.dayWise());
        return "reports/daily";
    }
}

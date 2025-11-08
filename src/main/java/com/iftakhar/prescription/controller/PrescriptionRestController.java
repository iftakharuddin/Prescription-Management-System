package com.iftakhar.prescription.controller;

import com.iftakhar.prescription.entity.Prescription;
import com.iftakhar.prescription.service.PrescriptionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PrescriptionRestController {
    private final PrescriptionService service;
    public PrescriptionRestController(PrescriptionService service){this.service=service;}

    @GetMapping("/prescription")
    public List<Prescription> get(@RequestParam(required=false)
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                  @RequestParam(required=false)
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to){
        LocalDate now = LocalDate.now();
        if(from==null) from = now.withDayOfMonth(1);
        if(to==null) to = now.withDayOfMonth(now.lengthOfMonth());
        return service.list(from, to);
    }
}

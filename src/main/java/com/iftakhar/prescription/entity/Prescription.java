package com.iftakhar.prescription.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "prescriptions")
public class Prescription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate prescriptionDate;

    @NotBlank(message = "Patient name is required")
    private String patientName;
    private Integer patientAge;
    private String patientGender;

    @Column(columnDefinition = "TEXT")
    private String diagnosis;

    @NotBlank(message = "Medicine name is required")
    @Column(columnDefinition = "TEXT")
    private String medicines;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate nextVisitDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public LocalDate getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(LocalDate nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}


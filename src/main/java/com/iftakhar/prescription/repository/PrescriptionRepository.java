package com.iftakhar.prescription.repository;

import com.iftakhar.prescription.entity.Prescription;
import com.iftakhar.prescription.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    @Query("SELECT p FROM Prescription p WHERE p.prescriptionDate BETWEEN :from AND :to")
    List<Prescription> findByDateRange(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query("SELECT p.prescriptionDate, COUNT(p) FROM Prescription p WHERE p.user.username = :username GROUP BY p.prescriptionDate ORDER BY p.prescriptionDate")
    List<Object[]> dayWiseByUser(@Param("username") String username);

    List<Prescription> findByUserAndPrescriptionDateBetween(User user, LocalDate start, LocalDate end);
}

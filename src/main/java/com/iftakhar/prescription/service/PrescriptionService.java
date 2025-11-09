package com.iftakhar.prescription.service;

import com.iftakhar.prescription.entity.Prescription;
import com.iftakhar.prescription.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PrescriptionService {
    private final PrescriptionRepository repo;
    public PrescriptionService(PrescriptionRepository repo) { this.repo = repo; }

    public List<Prescription> list(LocalDate from, LocalDate to) {
        return repo.findByDateRange(from, to);
    }

    public Prescription save(Prescription p) { 
        return repo.save(p); 
    }
    public Optional<Prescription> find(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }
    public void delete(Long id) {
        if (id != null) {
            repo.deleteById(id);
        }
    }

    public Map<LocalDate, Long> dayWise(String username) {
        List<Object[]> results = repo.dayWiseByUser(username);
        Map<LocalDate, Long> dayCounts = new LinkedHashMap<>();
        for (Object[] row : results) {
            LocalDate date = (LocalDate) row[0];
            Long count = (Long) row[1];
            dayCounts.put(date, count);
        }
        return dayCounts;
    }
}

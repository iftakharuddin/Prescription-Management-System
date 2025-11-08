package com.iftakhar.prescription.dto;

import java.time.LocalDate;

public class DayCount {
    private LocalDate day;
    private Long count;

    public DayCount(LocalDate day, Long count) {
        this.day = day;
        this.count = count;
    }
    public LocalDate getDay() { return day; }
    public Long getCount() { return count; }
}

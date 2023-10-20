package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final List<Doctor> doctors = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        doctor.setId(idCounter.incrementAndGet());
        doctors.add(doctor);
        return doctor;
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                doctor.setName(updatedDoctor.getName());
                return doctor;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctors.removeIf(doctor -> doctor.getId().equals(id));
    }
}

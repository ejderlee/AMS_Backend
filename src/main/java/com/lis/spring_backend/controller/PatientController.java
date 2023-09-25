package com.lis.spring_backend.controller;

import com.lis.spring_backend.entity.Patient;
import com.lis.spring_backend.repo.PatientRepository;
import com.lis.spring_backend.repo.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public Page<Patient> getPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }
/*
    @GetMapping("/patients2")
    public Page<Object[]> findPatients(Pageable pageable) {
        return patientRepository.findPatients(pageable);
    }*/

    @GetMapping("/patientListWithResult")
    public Page<PatientRepository.patientList> findPatients(Pageable pageable) {
        return patientRepository.findPatients( pageable)
                .map(x -> {
                    return new PatientRepository.patientList(
                            x[0],
                            x[1],
                            x[4],
                            x[5],
                            x[10],
                            x[11],
                            x[12],
                            x[13],
                            x[16],
                            x[29]
                    );
                });
    }

}

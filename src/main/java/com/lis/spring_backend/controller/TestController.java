package com.lis.spring_backend.controller;

import com.lis.spring_backend.entity.Patient;
import com.lis.spring_backend.entity.Test;
import com.lis.spring_backend.repo.PatientRepository;
import com.lis.spring_backend.repo.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TestRepository testRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/find/{testCode}")
    public List<Test> findAllByTestCode(@PathVariable String testCode) {
        return testRepository.findAllByCfg(testCode);
    }

 /*   @GetMapping("/find")
    public Page<Test> findAllByCfg(Pageable pageable) {
        return testRepository.findAll(pageable);
    }*/

/*
    @GetMapping("/find")
    public Page<Test> findAll(Pageable pageable) {
        return testRepository.findAll(pageable);
    }
*/

    @GetMapping("/patients")
    public Page<Patient> getPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @GetMapping("/results")
    public Page<Test> getResults(Pageable pageable) {
        return testRepository.findAll(pageable);
    }

    /*@GetMapping("/ams")
    public List<TestRepository.X> getResults(Pageable Pageable) {
        return testRepository.getResults(Pageable)
                .stream()
                .map(x -> {
                    return new TestRepository.X(
                            x[0],
                            x[1],
                            x[2],
                            x[3],
                            x[4],
                            x[5],
                            x[6],
                            x[7],
                            x[8],
                            x[9],
                            x[10]
                    );
                })
                .collect(Collectors.toList());
    }*/

    @GetMapping("/report2")
    public List<TestRepository.X2> getResults2() {
        return testRepository.getResults2()
                .stream()
                .map(x -> {
                    return new TestRepository.X2(
                            x[0],
                            x[1],
                            x[2],
                            x[3]
                    );
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/report3")
    public List<TestRepository.X3> getResults3() {
        return testRepository.getResults3()
                .stream()
                .map(x -> {
                    return new TestRepository.X3(
                            x[0],
                            x[1],
                            x[2],
                            x[3],
                            x[4],
                            x[5]
                    );
                })
                .collect(Collectors.toList());
    }
}
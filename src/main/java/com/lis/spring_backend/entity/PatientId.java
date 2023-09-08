package com.lis.spring_backend.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatientId implements Serializable {
    @Column(name = "REQUESTCODE")
    private String requestcode;

    @Column(name = "REQUESTERCODE")
    private String requestercode;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "BIRTHDATE")
    private Date birthdate;

    @Column(name = "SEX")
    private Integer sex;

    @Column(name = "PATI_AGE")
    private String patiage;

    @Column(name = "DATETIMEREQ")
    private Date datetime;

    public PatientId(
            String requestcode,
            String requestercode,
            String firstname,
            String lastname,
            Date birthdate,
            Integer sex,
            String patiage,
            Date datetime) {
        this.requestcode = requestcode;
        this.requestercode = requestercode;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.patiage = patiage;
        this.datetime = datetime;
    }

    public PatientId() {
    }
}

package com.lis.spring_backend.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatientId implements Serializable {
    @Column(name = "REQUESTCODE")
    private String REQUESTCODE;

    @Column(name = "REQUESTERCODE")
    private String REQUESTERCODE;

    @Column(name = "FIRSTNAME")
    private String FIRSTNAME;

    @Column(name = "LASTNAME")
    private String LASTNAME;

    @Column(name = "BIRTHDATE")
    private Date BIRTHDATE;

    @Column(name = "SEX")
    private Integer SEX;

    @Column(name = "PATI_AGE")
    private String PATI_AGE;

    @Column(name = "DATETIMEREQ")
    private Date DATETIMEREQ;

    public PatientId(
            String requestcode,
            String requestercode,
            String firstname,
            String lastname,
            Date birthdate,
            Integer sex,
            String patiage,
            Date datetime) {
        this.REQUESTCODE = requestcode;
        this.REQUESTERCODE = requestercode;
        this.FIRSTNAME = firstname;
        this.LASTNAME = lastname;
        this.BIRTHDATE = birthdate;
        this.SEX = sex;
        this.PATI_AGE = patiage;
        this.DATETIMEREQ = datetime;
    }

    public PatientId() {
    }
}

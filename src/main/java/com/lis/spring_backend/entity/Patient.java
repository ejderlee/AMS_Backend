package com.lis.spring_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SNAPREQUEST")
@IdClass(PatientId.class)
public class Patient {

    @Id
    private String requestcode;
    private String requestercode;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private Integer sex;
    private String patiage;
    private Date datetime;

}

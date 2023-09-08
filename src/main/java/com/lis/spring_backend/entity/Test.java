package com.lis.spring_backend.entity;

import jakarta.persistence.*;
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
@Table(name = "SNAPREQUESTTEST")
@IdClass(TestId.class)
public class Test {

    @Id
    private String requestcode;
    private String testcode;
    private String resultvalue;
    private String prevresultvalue;
    private String resultflag;
    private String status;
    private String analyser;
    private Date datetimeresult;
    private Integer normlow;
    private Integer normhigh;
    private String wono;
    private String shortdesc;
    private String cdqfault;
    private Integer rerunflag;
    private String unit;
}

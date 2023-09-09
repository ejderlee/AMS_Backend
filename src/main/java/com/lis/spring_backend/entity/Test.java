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
    private String requestCode;
    private String testCode;
    private String shortdesc;

    /*
    private Date datetimeresult;
    private String wono;
    private Integer rerunflag;
    private String unit;
    private String analyser;
    private Integer normlow;
    private Integer normhigh;
    private String cdqfault;
    private String status;
    private String resultflag;
    private String prevResultValue;
    private String resultValue;
 */
}

package com.lis.spring_backend.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TestId implements Serializable {
    @Column(name = "REQUESTCODE",nullable=true)
    private String requestCode;

    @Column(name = "TESTCODE",nullable=true)
    private String testCode;

    @Column(name = "SHORTDESC",nullable=true)
    private String shortdesc;

    /*



    @Column(name = "DATETIMERESULT",nullable=true)
    private Date datetimeresult;

    @Column(name = "WONO",nullable=true)
    private String wono;

    @Column(name = "RERUN_FLAG",nullable=true)
    private Integer rerunflag;

    @Column(name = "UNIT",nullable=true)
    private String unit;

    @Column(name = "ANALYSER",nullable=true)
    private String analyser;

    @Column(name = "NORMLOW",nullable=true)
    private Integer normlow;

    @Column(name = "NORMHIGH",nullable=true)
    private Integer normhigh;

    @Column(name = "CDQFAULT",nullable=true)
    private String cdqfault;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "RESULTFLAG")
    private Integer resultflag;

    @Column(name = "RESULTVALUE")
    private String resultValue;

    @Column(name = "PREVRESULTVALUE")
    private String prevResultValue;

    */


    public TestId(
            String requestCode,
            String testCode,
            String shortdesc

            /*

            Date datetimeresult,
            String wono,
            Integer rerunflag,
            String unit
            String analyser,
            String cdqfault,
            Integer normlow,
            Integer normhigh,
            Integer status,
            Integer resultflag,
            String prevResultValue,
            String resultValue,
            */) {
        this.requestCode = requestCode;
        this.testCode = testCode;
        this.shortdesc = shortdesc;

        /*

        this.datetimeresult = datetimeresult;
        this.wono = wono;
        this.rerunflag = rerunflag;
        this.unit = unit;
        this.analyser = analyser;
        this.normlow = normlow;
        this.normhigh = normhigh;
        this.cdqfault = cdqfault;
        this.status = status;
        this.resultflag = resultflag;
        this.prevResultValue = prevResultValue;
        this.resultValue = resultValue;
        */
    }

    public TestId() {
    }
}

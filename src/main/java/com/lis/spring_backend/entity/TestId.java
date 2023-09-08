package com.lis.spring_backend.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TestId implements Serializable {
    @Column(name = "REQUESTCODE")
    private String requestcode;

    @Column(name = "TESTCODE")
    private String testcode;

    @Column(name = "RESULTVALUE")
    private String resultvalue;

    @Column(name = "PREVRESULTVALUE")
    private String prevresultvalue;

    @Column(name = "RESULTFLAG")
    private Integer resultflag;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "ANALYSER")
    private String analyser;

    @Column(name = "DATETIMERESULT")
    private Date datetimeresult;

    @Column(name = "NORMLOW")
    private Integer normlow;

    @Column(name = "NORMHIGH")
    private Integer normhigh;

    @Column(name = "WONO")
    private String wono;

    @Column(name = "SHORTDESC")
    private String shortdesc;

    @Column(name = "CDQFAULT")
    private String cdqfault;

    @Column(name = "RERUN_FLAG")
    private Integer rerunflag;

    @Column(name = "UNIT")
    private String unit;


    public TestId(
            String requestcode,
            String testcode,
            String resultvalue,
            String prevresultvalue,
            Integer resultflag,
            Integer status,
            String analyser,
            Date datetimeresult,
            Integer normlow,
            Integer normhigh,
            String wono,
            String shortdesc,
            String cdqfault,
            Integer rerunflag,
            String unit) {
        this.requestcode = requestcode;
        this.testcode = testcode;
        this.resultvalue = resultvalue;
        this.prevresultvalue = prevresultvalue;
        this.resultflag = resultflag;
        this.status = status;
        this.analyser = analyser;
        this.datetimeresult = datetimeresult;
        this.normlow = normlow;
        this.normhigh = normhigh;
        this.wono = wono;
        this.shortdesc = shortdesc;
        this.cdqfault = cdqfault;
        this.rerunflag = rerunflag;
        this.unit = unit;
    }

    public TestId() {
    }
}

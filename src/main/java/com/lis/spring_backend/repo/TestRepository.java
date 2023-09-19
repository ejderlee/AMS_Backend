package com.lis.spring_backend.repo;

import com.lis.spring_backend.entity.Test;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
//    select t.* from SNAPREQUESTTEST t where t.REQUESTCODE='4062472920';

    @Query(value = " " +
            " select t.* " +
            "  from SNAPREQUESTTEST t " +
            "  where t.REQUESTCODE=:patientID ",
            nativeQuery = true
    )
    Page<Object[]> getResults(@Param("patientID") String testCode, Pageable pageable);

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Results {
        private Object PREVRESULTVALUE;
        private Object PREVRESULTDATE;
        private Object RESULTVALUE;
        private Object RESULTFLAG;
        private Object STATUS;
        private Object DLFACTOR;
        private Object DEVICECODE;
        private Object DATETIMERESULT;
        private Object NORMLOW;
        private Object NORMHIGH;
        private Object WONO;
        private Object SHORTDESC;
        private Object VALIUSER;
        private Object CDQFAULT;
        private Object UNIT;
        private Object RACKBARCODE_POS;
        private Object RACK_LOCATION;
        private Object SENT_TO_LIS_DATETIME










                ;
    }

    @Query(value = " " +
            " select " +
            " COUNT(SRT.TESTCODE), " +
            " SUM(ACTIVEINSTANCE - 1), " +
            " SRT.SHORTDESC " +
            " from SNAPREQUESTTEST SRT " +
            " where SRT.RESULTVALUE is not null " +
            " and SRT.NVAL = 1 " +
            " and SRT.resultVALUE <> '******' " +
            " and SRT.DEVICECODE <> 'QPL' " +
            " group by SRT.SHORTDESC ",
            nativeQuery = true
    )
    Page<Object[]> getTestNumbers(Pageable pageable);
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TestNumbers {
        private Object TESTCODE;
        private Object ACTIVEINSTANCE;
        private Object SHORTDESC;
    }


    @Query(value = " " +
            " select " +
            " COUNT(SRT.TESTCODE), " +
            " SUM(ACTIVEINSTANCE - 1), " +
            " SRT.SHORTDESC " +
            " from SNAPREQUESTTEST SRT " +
            " where SRT.RESULTVALUE is not null " +
            " and SRT.NVAL = 1 " +
            " and SRT.resultVALUE <> '******' " +
            " and SRT.DEVICECODE <> 'QPL' " +
            " group by SRT.SHORTDESC ",
            nativeQuery = true
    )
    List<Object[]> getResults2();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class X2 {
        private Object TESTCODE;
        private Object ACTIVEINSTANCE;
        private Object SHORTDESC;
    }

}




/*

    @Query(value = "" +
            " select " +
            "   *  " +
            " from CFGTEST", nativeQuery = true)
    List<Test> findAllByCfg(@Param("testCode") String testCode);

    */
/*   Page<Test> findByTestCode(String testCode,
                                 Pageable pageable);
   *//*


    @Query(value = " " +
            "select " +
            "   p.REQUESTERCODE, " +
            "       p.FIRSTNAME," +
            "       p.LASTNAME, " +
            "       p.BIRTHDATE," +
            "       p.PATI_AGE," +
            "       p.SEX," +
            "       p.DATETIMEREQ," +
            "       p.ORGANIZERFLAG, " +
            "       t.ANALYSER," +
            "       t.REQUESTCODE," +
            "       t.TESTCODE," +
            "       t.SHORTDESC,  " +
            "       t.RESULTVALUE," +
            "       t.PREVRESULTVALUE," +
            "       t.PREVRESULTDATE," +
            "       t.RESULTFLAG," +
            "       t.NORMLOW," +
            "       t.NORMHIGH," +
            "       t.WONO," +
            "       t.VALIUSER," +
            "       t.CDQFAULT," +
            "       t.RERUN_FLAG," +
            "       t.UNIT" +
            " from SNAPREQUESTTEST t, " +
            "           SNAPREQUEST p " +
            " where p.REQUESTCODE = t.REQUESTCODE ",
            countQuery = "" +
                    " select count(*) " +
                    " from SNAPREQUESTTEST t, " +
                    "           SNAPREQUEST p " +
                    " where p.REQUESTCODE = t.REQUESTCODE and t.REQUESTCODE=':sampleNo'",
            nativeQuery = true
    )
    Page<Object[]> getResults(Pageable pageable);

//    Page<Test> getResults(Pageable pageable);

@Data
@NoArgsConstructor
@AllArgsConstructor
public static class X {
    private Object REQUESTERCODE;
    private Object FIRSTNAME;
    private Object LASTNAME;
    private Object BIRTHDATE;
    private Object PATI_AGE;
    private Object SEX;
    private Object DATETIMEREQ;
    private Object ORGANIZERFLAG;
    private Object ANALYSER;
    private Object REQUESTCODE;
    private Object TESTCODE;
    private Object SHORTDESC;
    private Object RESULTVALUE;
    private Object PREVRESULTVALUE;
    private Object PREVRESULTDATE;
    private Object RESULTFLAG;
    private Object NORMLOW;
    private Object NORMHIGH;
    private Object WONO;
    private Object VALIUSER;
    private Object CDQFAULT;
    private Object RERUN_FLAG;
    private Object UNIT;
}


    @Query(value = "" +
            "SELECT " +
            "   TI.MONTH," +
            "   TI.CNT TESTADET," +
            "   TI.RERUN," +
            "   TABQC.NUMQC QCADET " +
            " FROM  (SELECT " +
            "                   COUNT(SRT.TESTCODE) AS CNT," +
            "                    SUM(ACTIVEINSTANCE - 1) AS RERUN, " +
            "                   TO_CHAR(SRT.DATETIMERESULT,'mm-yyyy') MONTH " +
            "               FROM STRREQUESTTEST SRT " +
            "               WHERE  extract(year from SRT.DATETIMERESULT) = extract(year from sysdate) " +
            "                   AND SRT.RESULTVALUE IS NOT NULL " +
            "                   AND SRT.NVAL = 1 " +
            "                   AND SRT.resultVALUE <>'******' " +
            "                   AND SRT.DEVICECODE <> 'QPL' " +
            "               GROUP BY TO_CHAR(SRT.DATETIMERESULT,'mm-yyyy')" +
            " ) TI, " +
            "               (SELECT " +
            "                   TO_CHAR(QC.TEST_RSLTDATE,'mm-yyyy') MONTH, " +
            "                   COUNT(*) AS NUMQC " +
            "               FROM QCM_WORK_CONTTESTMEAS QC " +
            "               WHERE extract(year from QC.TEST_RSLTDATE) = extract(year from sysdate) " +
            "               GROUP BY TO_CHAR(QC.TEST_RSLTDATE,'mm-yyyy') ) TABQC " +
            " WHERE  TI.MONTH = TABQC.MONTH " +
            " ORDER BY 1,2,3 ",
            nativeQuery = true)
    List<Object[]> getResults2();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class X2 {
        private Object MONTH;
        private Object TESTADET;
        private Object RERUN;
        private Object QCADET;
    }


    @Query(value = "SELECT TI.MONTH,TI.DEVICECODE,TI.TEST_NAME,TI.CNT TESTADET,TI.RERUN,TABQC.NUMQC QCADET FROM\n" +
            "\n" +
            "                                                                                           (SELECT COUNT(SRT.TESTCODE) AS CNT, SUM(ACTIVEINSTANCE - 1) AS RERUN,SRT.TESTCODE,T.SHORTDESC AS TEST_NAME,SRT.DEVICECODE,TO_CHAR(SRT.DATETIMERESULT,'mm-yyyy') MONTH\n" +
            "                                                                                            FROM STRREQUESTTEST SRT JOIN CFGTEST T ON T.TESTCODE = SRT.TESTCODE WHERE  extract(year from SRT.DATETIMERESULT)=extract(year from sysdate)\n" +
            "                                                                                                                                                                  AND SRT.RESULTVALUE IS NOT NULL AND SRT.NVAL = 1 AND SRT.resultVALUE <>'******' AND SRT.DEVICECODE<>'QPL'   GROUP BY SRT.TESTCODE,T.SHORTDESC,SRT.DEVICECODE,TO_CHAR(SRT.DATETIMERESULT,'mm-yyyy')) TI,\n" +
            "\n" +
            "                                                                                           (SELECT QC.TEST_CODE,QC.HOSTDEVICECODE,TO_CHAR(QC.TEST_RSLTDATE,'mm-yyyy') MONTH,COUNT(*) AS NUMQC FROM QCM_WORK_CONTTESTMEAS QC WHERE extract(year from QC.TEST_RSLTDATE)=extract(year from sysdate)\n" +
            "                                                                                            GROUP BY QC.TEST_CODE,QC.HOSTDEVICECODE,TO_CHAR(QC.TEST_RSLTDATE,'mm-yyyy')) TABQC\n" +
            "\n" +
            "WHERE TI.TESTCODE=TABQC.TEST_CODE(+) AND TI.DEVICECODE=TABQC.HOSTDEVICECODE(+) and  TI.MONTH=TABQC.MONTH(+) ORDER BY 1,2,3\n",
            nativeQuery = true)
    List<Object[]> getResults3();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class X3 {
        private Object MONTH;
        private Object DEVICECODE;
        private Object TEST_NAME;
        private Object TESTADET;
        private Object RERUN;
        private Object QCADET;
    }

}
*/


package com.lis.spring_backend.repo;

import com.lis.spring_backend.entity.Patient;
import com.lis.spring_backend.entity.Test;
import jakarta.persistence.Tuple;
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
import java.util.PrimitiveIterator;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    @Query(value = "" +
            " select " +
            "   *  " +
            " from CFGTEST", nativeQuery = true)
    List<Test> findAllByCfg(@Param("testCode") String testCode);

 /*   Page<Test> findByTestCode(String testCode,
                              Pageable pageable);
*/
    @Query(value = " select " +
            "   p.REQUESTERCODE,\n" +
            "       p.FIRSTNAME,\n" +
            "       p.LASTNAME,\n" +
            "       p.BIRTHDATE,\n" +
            "       p.PATI_AGE,\n" +
            "       p.SEX,\n" +
            "       p.ORGANIZERFLAG,\n" +
            "       t.ANALYSER,\n" +
            "       t.REQUESTCODE,\n" +
            "       t.TESTCODE,\n" +
            "       t.SHORTDESC  " +
            " from SNAPREQUESTTEST t, SNAPREQUEST p " +
            " where p.REQUESTCODE=t.REQUESTCODE ", nativeQuery = true)
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
        private Object ORGANIZERFLAG;
        private Object ANALYSER;
        private Object REQUESTCODE;
        private Object TESTCODE;
        private Object SHORTDESC;
    }

    @Query(value = "SELECT TI.MONTH,TI.CNT TESTADET,TI.RERUN,TABQC.NUMQC QCADET FROM\n" +
            "\n" +
            "(SELECT COUNT(SRT.TESTCODE) AS CNT, SUM(ACTIVEINSTANCE - 1) AS RERUN, TO_CHAR(SRT.DATETIMERESULT,'mm-yyyy') MONTH FROM \n" +
            "STRREQUESTTEST SRT WHERE  extract(year from SRT.DATETIMERESULT)=extract(year from sysdate) AND SRT.RESULTVALUE IS NOT NULL AND SRT.NVAL = 1  AND SRT.resultVALUE <>'******' AND SRT.DEVICECODE<>'QPL' \n" +
            "GROUP BY TO_CHAR(SRT.DATETIMERESULT,'mm-yyyy')) TI,\n" +
            "\n" +
            "(SELECT TO_CHAR(QC.TEST_RSLTDATE,'mm-yyyy') MONTH, COUNT(*) AS NUMQC \n" +
            "FROM QCM_WORK_CONTTESTMEAS QC WHERE extract(year from QC.TEST_RSLTDATE)=extract(year from sysdate) GROUP BY TO_CHAR(QC.TEST_RSLTDATE,'mm-yyyy') ) TABQC\n" +
            "\n" +
            "WHERE  TI.MONTH=TABQC.MONTH ORDER BY 1,2,3",
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

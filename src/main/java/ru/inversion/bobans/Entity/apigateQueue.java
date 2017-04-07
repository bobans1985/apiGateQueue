package ru.inversion.bobans.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by GrishukovVM on 10.03.2017.
 */
@Entity(
        name = "ru.inversion.bobans.Entity.bobans_apigate_queue"
)
//@Table(name="bobans_apigate_queue")
@NamedNativeQuery(name = "ru.inversion.bobans.Entity.bobans_apigate_queue", query = "SELECT a.*,"
        + " (select nvl(ccusname_sh,ccusname) from acc,cus where caccacc=a.AccD and iacccus=icusnum) as CLIENTFROMNAME, "
        + " (select nvl(ccusname_sh,ccusname) from acc,cus where caccacc=a.AccC and iacccus=icusnum) as CLIENTTONAME "
        + " from bobans_apigate_queue a ")
public class apigateQueue implements Serializable {

    private Long ID;
    private Long ITRNNUM;
    private Long ITRNANUM;
    private LocalDateTime DATETIMECREATE;
    private String STATUS;

    private String INFOTYPE;
    private Integer ROOLBACK;
    private BigDecimal AMOUNT;
    private BigDecimal AMOUNT_COMMIS;
    private String REQUEST;
    private String RESPONSE;
    private String ACCD;
    private String CURCODED;
    private String ACCC;
    private String CURCODEC;
    private String STREAM;

    private String PROCESSINGCODE;
    private String AUDITNUMBER;
    private String TRANSACTIONDATE;
    private String RRN;
    private String AUTHORIZATION;

    private String CLIENTFROMNAME;
    private String CLIENTTONAME;

    public apigateQueue() {
    }

    @Id
    @Column(
            name = "ID",
            nullable = false
    )
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Column(
            name = "ITRNNUM",
            nullable = false
    )
    public Long getITRNNUM() {
        return ITRNNUM;
    }

    public void setITRNNUM(Long ITRNNUM) {
        this.ITRNNUM = ITRNNUM;
    }

    @Column(
            name = "ITRNANUM",
            nullable = false
    )
    public Long getITRNANUM() {
        return ITRNANUM;
    }

    public void setITRNANUM(Long ITRNANUM) {
        this.ITRNANUM = ITRNANUM;
    }

    @Column(name = "DATETIMECREATE")
    public LocalDateTime getDATETIMECREATE() {
        return DATETIMECREATE;
    }

    public void setDATETIMECREATE(LocalDateTime DATETIMECREATE) {
        this.DATETIMECREATE = DATETIMECREATE;
    }

    @Column(name = "STATUS")
    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    @Column(name = "INFOTYPE")
    public String getINFOTYPE() {
        return INFOTYPE;
    }

    public void setINFOTYPE(String INFOTYPE) {
        this.INFOTYPE = INFOTYPE;
    }

    @Column(name = "ROOLBACK")
    public Integer getROOLBACK() {
        return ROOLBACK;
    }

    public void setROOLBACK(Integer ROOLBACK) {
        this.ROOLBACK = ROOLBACK;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    @Column(name = "AMOUNT_COMMIS")
    public BigDecimal getAMOUNT_COMMIS() {
        return AMOUNT_COMMIS;
    }

    public void setAMOUNT_COMMIS(BigDecimal AMOUNT_COMMIS) {
        this.AMOUNT_COMMIS = AMOUNT_COMMIS;
    }

    @Column(name = "ACCD")
    public String getACCD() {
        return ACCD;
    }

    public void setACCD(String ACCD) {
        this.ACCD = ACCD;
    }

    @Column(name = "CURCODED")
    public String getCURCODED() {
        return CURCODED;
    }

    public void setCURCODED(String CURCODED) {
        this.CURCODED = CURCODED;
    }

    @Column(name = "ACCC")
    public String getACCC() {
        return ACCC;
    }

    public void setACCC(String ACCC) {
        this.ACCC = ACCC;
    }

    @Column(name = "CURCODEC")
    public String getCURCODEC() {
        return CURCODEC;
    }

    public void setCURCODEC(String CURCODEC) {
        this.CURCODEC = CURCODEC;
    }

    @Column(name = "STREAM")
    public String getSTREAM() {
        return STREAM;
    }

    public void setSTREAM(String STREAM) {
        this.STREAM = STREAM;
    }

    @Column(name = "REQUEST")
    public String getREQUEST() {
        return REQUEST;
    }

    public void setREQUEST(String REQUEST) {
        this.REQUEST = REQUEST;
    }

    @Column(name = "RESPONSE")
    public String getRESPONSE() {
        return RESPONSE;
    }

    public void setRESPONSE(String RESPONSE) {
        this.RESPONSE = RESPONSE;
    }

    @Column(name = "PROCESSINGCODE")
    public String getPROCESSINGCODE() {
        return PROCESSINGCODE;
    }

    public void setPROCESSINGCODE(String PROCESSINGCODE) {
        this.PROCESSINGCODE = PROCESSINGCODE;
    }

    @Column(name = "AUDITNUMBER")
    public String getAUDITNUMBER() {
        return AUDITNUMBER;
    }

    public void setAUDITNUMBER(String AUDITNUMBER) {
        this.AUDITNUMBER = AUDITNUMBER;
    }

    @Column(name = "TRANSACTIONDATE")
    public String getTRANSACTIONDATE() {
        return TRANSACTIONDATE;
    }

    public void setTRANSACTIONDATE(String TRANSACTIONDATE) {
        this.TRANSACTIONDATE = TRANSACTIONDATE;
    }

    @Column(name = "RRN")
    public String getRRN() {
        return RRN;
    }

    public void setRRN(String RRN) {
        this.RRN = RRN;
    }

    @Column(name = "AUTHORIZATION")
    public String getAUTHORIZATION() {
        return AUTHORIZATION;
    }

    public void setAUTHORIZATION(String AUTHORIZATION) {
        this.AUTHORIZATION = AUTHORIZATION;
    }

    public String getCLIENTFROMNAME() {
        return CLIENTFROMNAME;
    }

    @Column(name = "CLIENTFROMNAME")
    public void setCLIENTFROMNAME(String CLIENTFROMNAME) {
        this.CLIENTFROMNAME = CLIENTFROMNAME;
    }

    public String getCLIENTTONAME() {
        return CLIENTTONAME;
    }

    @Column(name = "CLIENTTONAME")
    public void setCLIENTTONAME(String CLIENTTONAME) {
        this.CLIENTTONAME = CLIENTTONAME;
    }
}

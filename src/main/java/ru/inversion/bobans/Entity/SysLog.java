package ru.inversion.bobans.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by GrishukovVM on 15.03.2017.
 */
@Entity(
        name = "ru.inversion.bobans.Entity.ferro_systemlog"
)
@Table(name="ferro_systemlog")
public class SysLog {
    private Long ID;
    private LocalDateTime DATETIMECREATE;
    private String SYSTYPE;
    private String TXT;
    private String TXTLOB;
    private String STREAM;

    public SysLog() {
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

    @Column(name = "DATETIMECREATE")
    public LocalDateTime getDATETIMECREATE() {
        return DATETIMECREATE;
    }

    public void setDATETIMECREATE(LocalDateTime DATETIMECREATE) {
        this.DATETIMECREATE = DATETIMECREATE;
    }

    @Column(name = "SYSTYPE")
    public String getSYSTYPE() {
        return SYSTYPE;
    }

    public void setSYSTYPE(String SYSTYPE) {
        this.SYSTYPE = SYSTYPE;
    }

    @Column(name = "TXT")
    public String getTXT() {
        return TXT;
    }

    public void setTXT(String TXT) {
        this.TXT = TXT;
    }

    @Column(name = "TXTLOB")
    public String getTXTLOB() {
        return TXTLOB;
    }

    public void setTXTLOB(String TXTLOB) {
        this.TXTLOB = TXTLOB;
    }

    @Column(name = "STREAM")
    public String getSTREAM() {
        return STREAM;
    }

    public void setSTREAM(String STREAM) {
        this.STREAM = STREAM;
    }
}

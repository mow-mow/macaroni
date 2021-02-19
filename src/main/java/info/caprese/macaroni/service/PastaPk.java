package info.caprese.macaroni.service;

import info.caprese.macaroni.model.TimeZone;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Embeddable
public class PastaPk implements Serializable {
    public PastaPk() {

    }
    public PastaPk(String targetDate, TimeZone timeZone) {
        this.targetDate = targetDate;
        this.timeZone = timeZone;
    }
    private String targetDate;
    private TimeZone timeZone;
}

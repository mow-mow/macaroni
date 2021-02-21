package info.caprese.macaroni.service;

import info.caprese.macaroni.model.TimeZone;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PASTA")
@IdClass(PastaPk.class)
public class Pasta {
    @Id
    private String targetDate;
    @Id
    @Enumerated(EnumType.STRING)
    private TimeZone timeZone;
    private String pastaName;
    private String description;
    private String comment;
    private byte[] image;
    private LocalDateTime insertDateTime;
}

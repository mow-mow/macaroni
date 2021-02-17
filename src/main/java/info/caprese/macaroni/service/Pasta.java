package info.caprese.macaroni.service;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "PASTA")
public class Pasta {
    @Id
    private String targetDate;
    private String pastaName;
    private String description;
    private String comment;
}

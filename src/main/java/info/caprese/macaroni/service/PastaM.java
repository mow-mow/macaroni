package info.caprese.macaroni.service;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pasta_m")
public class PastaM {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer pastaId;
    private String pastaName;
    private String description;
    private String comment;
}

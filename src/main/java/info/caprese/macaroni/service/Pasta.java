package info.caprese.macaroni.service;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class Pasta {
    private String pastaName;
    private  String description;
    private String comment;
}

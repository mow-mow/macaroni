package info.caprese.macaroni.controller;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PastaRenponse {
    private String result;
    private String date;
    private String pastaName;
    private  String description;
    private String comment;
}

package info.caprese.macaroni.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import info.caprese.macaroni.model.TimeZone;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PastaRenponse {
    private Result result;
    private String date;
    private TimeZone timeZone;
    private String pastaName;
    private String description;
    private String comment;
    private String image;
    private String errorMsg;
}

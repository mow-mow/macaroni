package info.caprese.macaroni.controller.v2;

import info.caprese.macaroni.DateUtil;
import info.caprese.macaroni.controller.PastaRenponse;
import info.caprese.macaroni.controller.PastaValidator;
import info.caprese.macaroni.controller.Result;
import info.caprese.macaroni.model.TimeZone;
import info.caprese.macaroni.service.Pasta;
import info.caprese.macaroni.service.PastaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class PastaV2Controller {
    @Autowired
    PastaValidator validator;
    @Autowired
    PastaService service;

    @GetMapping(value = "/v2/pasta/")
    ResponseEntity<PastaRenponse> pastaGet() {
        LocalDateTime sysDate = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(sysDate);
        TimeZone timeZone = DateUtil.convertTimeZone(sysDate);

        Pasta pasta = service.findPasta(date, timeZone);

        return exchangeResponse(date, timeZone, pasta);
    }

    @GetMapping(value = "/v2/pasta/{date}/{time_zone}")
    ResponseEntity<PastaRenponse> pastaDateGet(@PathVariable("date") String date, @PathVariable("time_zone")TimeZone timeZone) {
        if (!validator.validateDate(date)) {
            log.info("入力チェック - [NG]");
            return new ResponseEntity<PastaRenponse>(PastaRenponse.builder().result(Result.NG)
                    .errorMsg("日付の指定が変だぞ:" + date).build(), HttpStatus.OK);
        }
        log.info("入力チェック - [OK]");

        Pasta pasta = service.findPasta(date, timeZone);

        return exchangeResponse(date, timeZone, pasta);
    }

    private ResponseEntity<PastaRenponse> exchangeResponse(String date, TimeZone timeZone, Pasta pasta) {
        return new ResponseEntity<PastaRenponse>(
                PastaRenponse.builder()
                        .result(Result.OK)
                        .date(date)
                        .timeZone(timeZone)
                        .pastaName(pasta.getPastaName())
                        .description(pasta.getDescription())
                        .comment(pasta.getComment())
                        .image(Base64.encodeBase64String(pasta.getImage()))
                        .build(), HttpStatus.OK);
    }
}

package info.caprese.macaroni.controller;

import info.caprese.macaroni.service.Pasta;
import info.caprese.macaroni.service.PastaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class PastaController {
    @Autowired
    PastaValidator validator;
    @Autowired
    PastaService service;

    @GetMapping(value = "/pasta/")
    ResponseEntity<PastaRenponse> pastaGet() {
        DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date=datetimeformatter.format(LocalDateTime.now());

        Pasta pasta = service.findPasta(date);

        return new ResponseEntity<PastaRenponse>(
                PastaRenponse.builder()
                        .result("OK")
                        .date(date)
                        .pastaName(pasta.getPastaName())
                        .description(pasta.getDescription())
                        .comment(pasta.getComment()).build(), HttpStatus.OK);
    }

    @GetMapping(value = "/pasta/{date}")
    ResponseEntity<PastaRenponse> pastaDateGet(@Validated @PathVariable("date") String date) {
        if (!validator.validateDate(date)) {
            log.info("入力チェック - [NG]");
            return new ResponseEntity<PastaRenponse>(PastaRenponse.builder().result("NG")
                    .errorMsg("日付の指定が変だぞ:" + date).build(), HttpStatus.OK);
        }
        log.info("入力チェック - [OK]");

        Pasta pasta = service.findPasta(date);
        return new ResponseEntity<PastaRenponse>(
                PastaRenponse.builder()
                        .result("OK")
                        .date(date)
                        .pastaName(pasta.getPastaName())
                        .description(pasta.getDescription())
                        .comment(pasta.getComment()).build(), HttpStatus.OK);
    }
}

package info.caprese.macaroni.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@Slf4j
public class PastaController {

    @GetMapping(value = "/pasta/")
    ResponseEntity<PastaRenponse> pastaGet() {
        return pastaDateGet(LocalDateTime.now().toString());
    }

    @GetMapping(value = "/pasta/{date}")
    ResponseEntity<PastaRenponse> pastaDateGet( @PathVariable("date") String date) {
        log.info(date);

        return new ResponseEntity<PastaRenponse>(PastaRenponse.builder().result("OK").date(date).pastaName("ボロネーゼ").description("ひき肉をトマトやワインと一緒に煮込んだパスタのことだぞ").comment("お肉を食べて体力をつけるぞ！").build(), HttpStatus.OK);
    }
}

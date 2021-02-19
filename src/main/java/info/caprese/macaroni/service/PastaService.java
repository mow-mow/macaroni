package info.caprese.macaroni.service;

import info.caprese.macaroni.model.PastaMRepository;
import info.caprese.macaroni.model.PastaRepository;
import info.caprese.macaroni.model.TimeZone;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class PastaService {

    @Autowired
    private PastaRepository pastaRepository;

    @Autowired
    private PastaMRepository pastaMRepository;

    public Pasta findPasta(String date, TimeZone timeZone) {
        Optional<Pasta> pasta = pastaRepository.findById(new PastaPk(date, timeZone));
        if (pasta.isPresent()) {
            log.info("既存パスタあり");
            return pasta.get();
        }
        log.info("既存パスタなし");
        return generatePasta(date, timeZone);

    }

    private Pasta generatePasta(String date, TimeZone timeZone) {
        log.info("パスタ生成処理 開始");
        Pasta pasta = new Pasta();
        pasta.setTargetDate(date);
        pasta.setInsertDateTime(LocalDateTime.now());
        pasta.setTimeZone(timeZone);

        Optional<PastaM> pastM = pastaMRepository.findPastaMRandom();
        pastM.ifPresent(
                m ->{
                pasta.setPastaName(m.getPastaName());
                pasta.setDescription(m.getDescription());
                pasta.setComment(m.getComment());
                }
        );
        log.info("パスタ保存開始");
        pastaRepository.save(pasta);
        log.info("パスタ保存終了");
        log.info("パスタ生成処理終了");
        return pasta;
    }
}

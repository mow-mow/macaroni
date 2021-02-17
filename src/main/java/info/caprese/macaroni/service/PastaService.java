package info.caprese.macaroni.service;

import info.caprese.macaroni.model.PastaMRepository;
import info.caprese.macaroni.model.PastaRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class PastaService {

    @Autowired
    private PastaRepository pastaRepository;

    @Autowired
    private PastaMRepository pastaMRepository;

    public Pasta findPasta(String date) {

        Optional<Pasta> pasta = pastaRepository.findById(date);
        if (pasta.isPresent()) {
            return pasta.get();
        }
        return generatePasta(date);

    }

    private Pasta generatePasta(String date) {
        Pasta pasta = new Pasta();
        pasta.setTargetDate(date);

        Optional<PastaM> pastM = pastaMRepository.findPastaMRandom();
        pastM.ifPresent(
                m ->{
                pasta.setPastaName(m.getPastaName());
                pasta.setDescription(m.getDescription());
                pasta.setComment(m.getComment());
                }
        );
        pastaRepository.save(pasta);

        return pasta;
    }
}

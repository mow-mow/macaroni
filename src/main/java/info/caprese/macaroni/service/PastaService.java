package info.caprese.macaroni.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class PastaService {
    public Pasta findPasta(String date) {
        if (LocalDateTime.now().getSecond()%3 == 1) {
            return Pasta.builder().pastaName("ボロネーゼ").description("ひき肉をトマトやワインと一緒に煮込んだパスタのことだぞ").comment("お肉も食べて体力をつけるぞ！").build();
        } else {
            return Pasta.builder().pastaName("ナポリタン").description("トマトケチャップで味付けした日本発症のパスタでナポリは関係ないぞ！").comment("タバスコをかけると大人の味に変身だ！").build();
        }
    }
}

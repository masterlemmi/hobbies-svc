package com.lemzki.hobby;

import com.lemzki.common.reader.CsvData;
import com.lemzki.common.reader.ResourceReader;
import com.lemzki.hobby.language.Language;
import com.lemzki.hobby.language.LanguageRepository;
import com.lemzki.hobby.language.phrase.Phrase;
import com.lemzki.hobby.language.phrase.PhraseRepository;
import com.lemzki.hobby.language.translation.Translation;
import com.lemzki.hobby.language.translation.TranslationRepository;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lemzki"})
public class HobbiesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HobbiesServiceApplication.class, args);
    }

    @Autowired
    ResourceReader<CsvData> reader;

    @Bean
    ApplicationRunner init(LanguageRepository langRepo, PhraseRepository phraseRepo, TranslationRepository tranRepo) {
        return args -> {
            CsvData shortcuts = reader.read("phrases.csv");
            List<CSVRecord> rows = shortcuts.getRecords();

            Language cebuano = langRepo.findByName("Cebuano");
            Language ilocano = langRepo.findByName("Ilocano");


            rows.forEach(row -> {
                String english = row.get(1);
                String cebuTran = row.get(2);
                Phrase phrase = new Phrase();
                phrase.setPhrase(english);

                Phrase savedPhrase = phraseRepo.save(phrase);
                Translation translation = new Translation();
                translation.setLanguage(cebuano);
                translation.setTranslation(cebuTran);
                tranRepo.save(translation);
                savedPhrase.addTranslation(translation);
                phraseRepo.save(phrase);
            });

            Phrase etoBalay = phraseRepo.findByPhrase("this is my house");
            Translation iloTran = new Translation();
            iloTran.setTranslation("Daytoy ti balay ko");
            iloTran.setLanguage(ilocano);
            iloTran.setPhrase(etoBalay);
            Translation savedTran = tranRepo.save(iloTran);
//            etoBalay.addTranslation(savedTran);
//            phraseRepo.save(etoBalay);
        };


    }

}
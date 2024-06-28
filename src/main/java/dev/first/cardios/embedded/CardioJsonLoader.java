package dev.first.cardios.embedded;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CardioJsonLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CardioJsonLoader.class);
    private  final JdbcCardioRepo jdbcCardioRepo;
    private final ObjectMapper objectMapper;

    public CardioJsonLoader(JdbcCardioRepo jdbcCardioRepo, ObjectMapper objectMapper) {
        this.jdbcCardioRepo = jdbcCardioRepo;
        this.objectMapper = objectMapper;
    }



    @Override
    public void run(String... args) throws Exception {
        if(jdbcCardioRepo.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/cardio.json")) {
                CardioR allRuns = objectMapper.readValue(inputStream, CardioR.class);
                log.info("Reading {} runs from JSON data and saving to in-memory database.", allRuns.cardio().size());
                jdbcCardioRepo.saveAll(allRuns.cardio());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Runs from JSON data because the database contains data.");
        }
    }
}


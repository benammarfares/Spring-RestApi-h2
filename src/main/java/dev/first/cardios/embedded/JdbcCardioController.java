package dev.first.cardios.embedded;


import dev.first.cardios.cardio.Cardio;
import dev.first.cardios.cardio.CardioNotFoundExepetion;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cardio/jdbc")
public class JdbcCardioController {


    private final JdbcCardioRepo jdbcCardioRepo;

    public JdbcCardioController(JdbcCardioRepo jdbcCardioRepo) {
        this.jdbcCardioRepo = jdbcCardioRepo;
    }

    @GetMapping("/AllCardio")
    List<Cardio> findAll(){
        return jdbcCardioRepo.findAll();
    }

    @RequestMapping("/{id}")
    Cardio findById(@PathVariable Integer id){
        Optional<Cardio> cardio = jdbcCardioRepo.FindById(id);
        if (cardio.isEmpty()){
            throw  new CardioNotFoundExepetion();
        }
        return cardio.get();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void addCardio(@Valid @RequestBody Cardio cardio)
    {
        jdbcCardioRepo.create(cardio);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateCardio(@Valid @RequestBody Cardio cardio,@PathVariable Integer id){
        jdbcCardioRepo.update(cardio,id);
    }




    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteCardio(@PathVariable Integer id){
        jdbcCardioRepo.delete(id);
    }




}

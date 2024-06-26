package dev.first.runnerz.cardio;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cardio")
public class CardioController {

private final CardioRepo cardioRepo ;


  public CardioController(CardioRepo cardioRepo) {
      this.cardioRepo = cardioRepo;
  }

  @RequestMapping("/AllCardio")
  List<Cardio> findAll(){
      return cardioRepo.findAll();
  }


  @RequestMapping("/{id}")
    Cardio findById(@PathVariable Integer id){
    Optional<Cardio> cardio = cardioRepo.findById(id);
    if (cardio.isEmpty()){
      throw  new CardioNotFoundExepetion();
    }
    return cardio.get();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  void addCardio(@Valid @RequestBody Cardio cardio)
  {
    cardioRepo.add(cardio);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  void updateCardio(@Valid @RequestBody Cardio cardio,@PathVariable Integer id){
      cardioRepo.update(cardio,id);
  }




  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{id}")
  void deleteCardio(@PathVariable Integer id){
      cardioRepo.delete(id);
  }



}

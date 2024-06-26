package dev.first.runnerz.cardio;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class CardioRepo {
     private List <Cardio> cardioList = new ArrayList<>();

     List <Cardio> findAll(){
         return cardioList;
     }

     Optional <Cardio> findById(int id){
         return cardioList.stream().filter(cardio->cardio.id()==id).findFirst();
     }

     @PostConstruct
    private void init(){
         cardioList.add(new Cardio(1,
                 "Press",
                 "Pressing is a great way to get in shape and lose weight. It can improve your health and mental well-being. It can also help you lose weight and improve your cardiovascular health.",
                 Equipment.BARBELL,
                 "Chest",
                 "Beginner",
                 "Cardio"));
         cardioList.add(new Cardio(2,
                 "Bench",
                 "Benching is a great way to get in shape and lose weight. It can improve your health and mental well-being. It can also help you lose weight and improve your cardiovascular health.",
                 Equipment.BARBELL,
                 "Chest",
                 "Beginner",
                 "Cardio"));}

    void add (Cardio cardio){
        cardioList.add(cardio);
    }

    void update(Cardio cardio,Integer id){
         Optional<Cardio> cardioOptional = findById(id);
         if (cardioOptional.isPresent()){
                 cardioList.set(cardioList.indexOf(cardioOptional.get()),cardio);
         }
    }

    void delete(Integer id){
         Optional<Cardio> cardioOptional = findById(id);
        if (cardioOptional.isPresent()){
            cardioList.remove(cardioOptional.get());
        }
    }


}


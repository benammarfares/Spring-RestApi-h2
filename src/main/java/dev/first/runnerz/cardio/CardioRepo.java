package dev.first.runnerz.cardio;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardioRepo {
     private List <Cardio> cardioList = new ArrayList<>();

     List <Cardio> findAll(){
         return cardioList;
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

}

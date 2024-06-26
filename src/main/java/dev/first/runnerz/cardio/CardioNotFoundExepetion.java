package dev.first.runnerz.cardio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardioNotFoundExepetion extends RuntimeException{
    public CardioNotFoundExepetion() {
        super("Cardio not found");
    }
}

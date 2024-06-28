package dev.first.cardios.cardio;

import jakarta.validation.constraints.NotEmpty;

public record Cardio(
     Integer id,
    @NotEmpty
    String name,
    @NotEmpty
    String description,
    Equipment equipment,
    @NotEmpty
    String targetMuscle,
    @NotEmpty
    String difficulty,
    @NotEmpty
    String typee
)


{

}

package com.yourcompany.pollservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PollQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Exemple: "What do you most love to do?"
    private String optionA; // Exemple: "Watch TV"
    private String optionB; // Exemple: "Play the computer"
    private String optionC; // Exemple: "Hanging out with friends"
    private String optionD; // Exemple: "Travel the world"


    public PollQuestion(String s, String watchTv, String playOnTheComputer, String hangOutWithFriends, String travelTheWorld) {
    }

    public PollQuestion() {

    }
}


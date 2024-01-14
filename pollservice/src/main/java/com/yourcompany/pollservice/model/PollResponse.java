package com.yourcompany.pollservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PollResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private PollQuestion question;

    private String selectedOption;

    public PollResponse(Long userId, PollQuestion question, String selectedOption) {
        this.userId = userId;
        this.question = question;
        this.selectedOption = selectedOption;
    }

}

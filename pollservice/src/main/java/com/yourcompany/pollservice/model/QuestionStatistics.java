package com.yourcompany.pollservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class QuestionStatistics {
    // Getters et setters pour questionId
    private Long questionId;
    // Getters et setters pour optionCounts
    private Map<String, Long> optionCounts;

    public QuestionStatistics(Long questionId, Map<String, Long> optionCounts) {
        this.questionId = questionId;
        this.optionCounts = optionCounts;
    }

}

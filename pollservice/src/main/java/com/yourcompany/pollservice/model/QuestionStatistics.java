package com.yourcompany.pollservice.model;

import java.util.Map;

public class QuestionStatistics {
    private Long questionId;
    private Map<String, Long> optionCounts;

    public QuestionStatistics(Long questionId, Map<String, Long> optionCounts) {
        this.questionId = questionId;
        this.optionCounts = optionCounts;
    }

    // Getters et setters pour questionId
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    // Getters et setters pour optionCounts
    public Map<String, Long> getOptionCounts() {
        return optionCounts;
    }

    public void setOptionCounts(Map<String, Long> optionCounts) {
        this.optionCounts = optionCounts;
    }
}

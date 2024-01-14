package com.yourcompany.pollservice.dto;

import jakarta.validation.constraints.NotBlank;

public class PollQuestionDto {


    @NotBlank(message = "Question title is required")
    private String title;

    @NotBlank(message = "Option A is required")
    private String optionA;

    @NotBlank(message = "Option B is required")
    private String optionB;

    @NotBlank(message = "Option C is required")
    private String optionC;

    @NotBlank(message = "Option D is required")
    private String optionD;

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }


}


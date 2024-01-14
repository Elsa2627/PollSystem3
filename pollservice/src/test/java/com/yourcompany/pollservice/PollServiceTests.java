package com.yourcompany.pollservice;

import com.yourcompany.pollservice.model.PollQuestion;
import com.yourcompany.pollservice.repository.PollQuestionRepository;
import com.yourcompany.pollservice.service.PollService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PollServiceTests {

    @MockBean
    private PollQuestionRepository pollQuestionRepository;

    @Autowired
    private PollService pollService;

    @Test
    public void whenGetPollQuestions_thenQuestionsShouldBeReturned() {
        // Arrange
        List<PollQuestion> mockQuestions = Arrays.asList(
                new PollQuestion("What is your favorite activity?", "Watch TV", "Play on the computer", "Hang out with friends", "Travel the world"),
                new PollQuestion("What is your favorite food?", "Pizza", "Hamburger", "Salad", "Sushi")
        );
        when(pollQuestionRepository.findAll()).thenReturn(mockQuestions);

        // Act
        List<PollQuestion> questions = pollService.getAllPollQuestions();

        // Assert
        assertEquals(mockQuestions.size(), questions.size(), "The size of the returned questions should match the mock");
        assertEquals(mockQuestions, questions, "The returned questions should match the mock data");
    }

    @Test
    public void testPollCreation() {
        // Arrange
        PollQuestion newPollQuestion = new PollQuestion("What is your favorite movie?", "Inception", "Titanic", "Avengers", "The Lord of the Rings");
        when(pollQuestionRepository.save(any(PollQuestion.class))).thenReturn(newPollQuestion);

        // Act
        PollQuestion createdPollQuestion = pollService.createPollQuestion(newPollQuestion);

        // Assert
        assertNotNull(createdPollQuestion, "Created poll question should not be null");
        // Additional assertions to verify the returned object properties
    }

    // Include additional tests here

    // Example of another test case
    // ...

}

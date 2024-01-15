package com.yourcompany.pollservice.controller;

import com.yourcompany.pollservice.dto.PollQuestionDto;
import com.yourcompany.pollservice.model.PollQuestion;
import com.yourcompany.pollservice.model.QuestionStatistics;
import com.yourcompany.pollservice.service.PollService;
import com.yourcompany.pollservice.service.StatisticsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;
    private StatisticsService statisticsService;

    @Autowired
    public PollController(PollService pollService, StatisticsService statisticsService) {
        this.pollService = pollService;
    }


    @PostMapping("/questions/create")
    public ResponseEntity<PollQuestion> createQuestion(@Valid @RequestBody PollQuestionDto pollQuestionDto) {
        PollQuestion newQuestion = pollService.createQuestion(pollQuestionDto);
        return ResponseEntity.ok(newQuestion);
    }


    @GetMapping("/statistics/{questionId}")
    public ResponseEntity<QuestionStatistics> getQuestionStatistics(@PathVariable Long questionId) {
        QuestionStatistics statistics = statisticsService.getStatisticsForQuestion(questionId); // Utilisez l'instance de statisticsService
        return ResponseEntity.ok(statistics);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<PollQuestion>> getAllQuestions() {
        List<PollQuestion> questions = pollService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<PollQuestion> getQuestionById(@PathVariable Long id) {
        return pollService.getQuestionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<PollQuestion> updateQuestion(@PathVariable Long id, @RequestBody PollQuestion questionDetails) {
        return pollService.updateQuestion(id, questionDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/polls/{questionId}/statistics")
    public Map<String, Long> getStatistics(@PathVariable Long questionId) {
        return pollService.getResponseStatisticsForQuestion(questionId);
    }

    @GetMapping("/polls/{questionId}/responses/count")
    public List<Object[]> getTotalResponses(@PathVariable Long questionId) {
        return pollService.getTotalResponsesForQuestion(questionId);
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        if (pollService.deleteQuestion(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

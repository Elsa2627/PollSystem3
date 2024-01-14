package com.yourcompany.pollservice.service;

import com.yourcompany.pollservice.dto.PollQuestionDto;
import com.yourcompany.pollservice.model.PollQuestion;
import com.yourcompany.pollservice.model.PollResponse;
import com.yourcompany.pollservice.model.QuestionStatistics;
import com.yourcompany.pollservice.repository.PollQuestionRepository;
import com.yourcompany.pollservice.repository.PollResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PollService {

    private final PollQuestionRepository pollQuestionRepository;

    public PollService(PollQuestionRepository pollQuestionRepository) {
        this.pollQuestionRepository = pollQuestionRepository;
    }

    public Optional<PollQuestion> getQuestionByTitle(String title) {
        return pollQuestionRepository.findByTitle(title);
    }

    public List<PollQuestion> searchQuestionsByKeyword(String keyword) {
        return pollQuestionRepository.findByTitleContaining(keyword);
    }

    private PollResponseRepository pollResponseRepository;

    @Autowired
    public PollService(PollQuestionRepository pollQuestionRepository,
                       PollResponseRepository pollResponseRepository) {
        this.pollQuestionRepository = pollQuestionRepository;
        this.pollResponseRepository = pollResponseRepository;
    }


    public PollQuestion saveQuestion(PollQuestion question) {
        return pollQuestionRepository.save(question);
    }

    public Optional<PollQuestion> getQuestionById(Long id) {
        return pollQuestionRepository.findById(id);
    }

    public List<PollQuestion> getAllQuestions() {
        return pollQuestionRepository.findAll();
    }

    public boolean deleteQuestion(Long id) {
        if (pollQuestionRepository.existsById(id)) {
            pollQuestionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<PollQuestion> updateQuestion(Long id, PollQuestion questionDetails) {
        return pollQuestionRepository.findById(id).map(question -> {
            question.setTitle(questionDetails.getTitle());
            question.setOptionA(questionDetails.getOptionA());
            question.setOptionB(questionDetails.getOptionB());
            question.setOptionC(questionDetails.getOptionC());
            question.setOptionD(questionDetails.getOptionD());
            return pollQuestionRepository.save(question);
        });
    }

    public PollResponse saveResponse(PollResponse response) {
        return pollResponseRepository.save(response);
    }

    public void deleteUserResponses(Long userId) {
        pollResponseRepository.deleteByUserId(userId);
    }


    public List<PollResponse> getResponsesByUser(Long userId) {
        return pollResponseRepository.findByUserId(userId);
    }

    public Map<String, Long> getResponseStatisticsForQuestion(Long questionId) {
        List<Object[]> results = pollResponseRepository.countTotalResponsesByOption(questionId);
        Map<String, Long> statistics = new HashMap<>();
        for (Object[] result : results) {
            String option = (String) result[0];
            long count = (Long) result[1];
            statistics.put(option, count);
        }
        return statistics;
    }


    public List<Object[]> getTotalResponsesForQuestion(Long questionId) {
        return pollResponseRepository.countTotalResponsesByOption(questionId);
    }


    public Long getNumberOfAnsweredQuestionsByUser(Long userId) {

        return pollResponseRepository.findDistinctQuestionCountByUserId(userId);
    }


    public List<QuestionStatistics> getAllQuestionsWithStatistics() {
        List<QuestionStatistics> statisticsList = new ArrayList<>();
        List<PollQuestion> questions = pollQuestionRepository.findAll();

        for (PollQuestion question : questions) {
            Map<String, Long> responseCounts = getResponseStatisticsForQuestion(question.getId());
            QuestionStatistics statistics = new QuestionStatistics(question.getId(), responseCounts);
            statisticsList.add(statistics);
        }

        return statisticsList;
    }

    @PostConstruct
    private void init() {
        if (pollQuestionRepository.count() == 0) {
            PollQuestion question1 = new PollQuestion();
            question1.setTitle("What do you most love to do?");
            question1.setOptionA("Watch TV");
            question1.setOptionB("Play the computer");
            question1.setOptionC("Hanging out with friends");
            question1.setOptionD("Travel the world");
            pollQuestionRepository.save(question1);
        }
    }

    public PollQuestion createQuestion(PollQuestionDto pollQuestionDto) {
        PollQuestion newQuestion = new PollQuestion();
        newQuestion.setTitle(pollQuestionDto.getTitle());
        newQuestion.setOptionA(pollQuestionDto.getOptionA());
        newQuestion.setOptionB(pollQuestionDto.getOptionB());
        newQuestion.setOptionC(pollQuestionDto.getOptionC());
        newQuestion.setOptionD(pollQuestionDto.getOptionD());

        return pollQuestionRepository.save(newQuestion);
    }


    public PollQuestion createPollQuestion(PollQuestion newPollQuestion) {
        return newPollQuestion;
    }

    public List<PollQuestion> getAllPollQuestions() {
        return null;
    }
}

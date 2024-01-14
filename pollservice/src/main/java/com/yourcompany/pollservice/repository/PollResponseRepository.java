package com.yourcompany.pollservice.repository;

import com.yourcompany.pollservice.model.PollResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollResponseRepository extends JpaRepository<PollResponse, Long> {

    void deleteByUserId(Long userId);

    List<PollResponse> findByQuestionId(Long questionId);

    @Query("SELECT pr.selectedOption, COUNT(pr) FROM PollResponse pr WHERE pr.question.id = :questionId GROUP BY pr.selectedOption")
    List<Object[]> countTotalResponsesByOption(@Param("questionId") Long questionId);

    List<PollResponse> findByUserId(Long userId);

    @Query("SELECT COUNT(pr) FROM PollResponse pr WHERE pr.userId = :userId")
    Long countByUserId(@Param("userId") Long userId);

    @Query("SELECT COUNT(DISTINCT pr.question.id) FROM PollResponse pr WHERE pr.userId = :userId")
    Long findDistinctQuestionCountByUserId(@Param("userId") Long userId);
}

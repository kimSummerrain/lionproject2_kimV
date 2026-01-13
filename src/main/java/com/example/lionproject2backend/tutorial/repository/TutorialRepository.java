package com.example.lionproject2backend.tutorial.repository;

import com.example.lionproject2backend.tutorial.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByTitleContainingOrDescriptionContaining(String keyword, String keyword1);
    Optional<Tutorial> findByIdAndMentorId(Long tutorialId, Long mentorId);
}

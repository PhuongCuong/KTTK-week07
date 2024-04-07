package com.example.cau_2.responsitory;

import com.example.cau_2.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectResponsitory extends JpaRepository<Subject,Long> {
    Optional<Subject> findSubjectBySubId(Long id);
}

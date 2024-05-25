package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramDocumentRepository extends JpaRepository<ProgramDocument,Integer> {
    List<ProgramDocument> getAllByProgramProgramId(Integer id);
}

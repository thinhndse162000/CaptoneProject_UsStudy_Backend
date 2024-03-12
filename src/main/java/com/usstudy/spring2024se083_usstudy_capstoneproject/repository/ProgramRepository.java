package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> getProgramsByUniversityId(int universityId);
    List<Program> getProgramsByMajorId(int majorId);
    List<Program> getProgramsByUniversityIdAndMajorId(int universityId,int majorId);
    List<Program> getProgramsByProgramNameContains(String programName);
}

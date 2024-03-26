package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> getProgramsByUniversityUniversityId(int universityId);

    List<Program> getProgramsByMajorMajorId(int majorId);

    List<Program> getProgramsByUniversityUniversityIdAndMajorMajorId(int universityId, int majorId);

    List<Program> getProgramsByNameProgramContains(String programName);

    @Query("select sp from Program sp where sp.programType.programTypeId = :programTypeId")
    List<Program> getProgramByProgramTypeId(Integer programTypeId);

    @Query("select sp from Program sp where sp.semester.semesterId = :semesterId")
    List<Program> getProgramBySemesterId(Integer semesterId);
}

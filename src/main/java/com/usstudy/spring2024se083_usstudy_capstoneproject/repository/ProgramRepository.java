package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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

    @Query("SELECT p FROM Program p "
            + "WHERE (:#{#req.programName} is null OR p.nameProgram like %:#{#req.programName}%) "
            + "AND (:#{#req.duration} is null OR  p.duration like  %:#{#req.duration}%) "
            + "AND (:#{#req.level} is null OR p.level like %:#{#req.level}%) "
            + "AND (:#{#req.status} is null OR p.status like %:#{#req.status}%) "
            + "AND (:#{#req.tuition} = 0 OR p.tuition = :#{#req.tuition})"
    )
    List<Program> getProgramByRequest(@Param(value = "req") ProgramFilterRequest req);

    @Query("SELECT p FROM Program p INNER JOIN p.university u WHERE u.universityId = :universityId")
    List<Program> getProgrambyUniversityId(Integer universityId);

    @Query("SELECT p FROM Program p INNER JOIN p.semester s WHERE s.endDate = :date")
    List<Program> getProgrambyEndDate(Date date);

    @Query("SELECT p FROM Program p INNER JOIN p.semester s WHERE s.startDate = :date")
    List<Program> getProgrambyStartDate(Date date);
}

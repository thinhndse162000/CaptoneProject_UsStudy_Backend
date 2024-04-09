package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramStageRepository extends JpaRepository<ProgramStage, Integer> {
    @Query("select u from ProgramStage u where u.program.programId = :programId " +
            "Order By u.programStageId ASC")
    List<ProgramStage> getProgramStageByProgramProgramIdOrderByProgramStageIdAcs(Integer programId);
}

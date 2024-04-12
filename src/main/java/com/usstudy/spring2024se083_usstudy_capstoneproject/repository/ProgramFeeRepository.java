package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramFeeRepository extends JpaRepository<ProgramFee,Integer> {

    @Query("select p.Sum(p.amount) from ProgramFee p " +
            "where p.program.programId = :programId")
    Integer getSumByProgramId(Integer programId);

    @Query("select p from ProgramFee p " +
            "where p.program.programId = :programId")
    List<ProgramFee> getByProgramId(Integer programId);
}

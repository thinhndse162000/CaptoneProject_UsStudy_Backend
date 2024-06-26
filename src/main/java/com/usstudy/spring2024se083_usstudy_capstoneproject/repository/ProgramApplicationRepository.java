package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramApplicationRepository extends JpaRepository<ProgramApplication, Integer> {
    @Query("SELECT pa FROM ProgramApplication pa " +
            "WHERE pa.studentProfile.studentProfileId = :id " +
            "ORDER BY pa.updateDate DESC")
    List<ProgramApplication> findByStudentProfileStudentProfileId(Integer id);

    @Query("SELECT pa FROM ProgramApplication pa JOIN pa.studentProfile sp WHERE sp.customer.customerId = :id")
    List<ProgramApplication> getProgramApplicationByCustomerId(Integer id);

    @Query("SELECT pa FROM ProgramApplication pa JOIN pa.program p " +
            "JOIN p.university u " +
            "JOIN u.staff s " +
            "WHERE u.staff.staffId = :id " +
            "ORDER BY pa.updateDate DESC, pa.programApplicationId DESC")
    List<ProgramApplication> getAllByStaffId(Integer id);

    @Query("SELECT pa FROM ProgramApplication pa " +
            "ORDER BY pa.updateDate DESC, pa.programApplicationId DESC")
    List<ProgramApplication> getAllByUpdateDate();
}

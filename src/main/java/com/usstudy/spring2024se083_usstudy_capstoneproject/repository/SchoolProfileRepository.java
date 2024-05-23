package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.SchoolProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolProfileRepository extends JpaRepository<SchoolProfile,Integer> {
    List<SchoolProfile> getAllByStudentProfileStudentProfileId(Integer id);
}

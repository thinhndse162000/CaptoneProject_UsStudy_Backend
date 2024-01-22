package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

}

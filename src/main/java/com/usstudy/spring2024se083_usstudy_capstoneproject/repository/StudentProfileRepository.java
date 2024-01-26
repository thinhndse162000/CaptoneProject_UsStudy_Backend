package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends CrudRepository<StudentProfile, Integer> {


    Iterable<StudentProfile> findByCustomerId(@Param(value ="req") Integer customerId);
}
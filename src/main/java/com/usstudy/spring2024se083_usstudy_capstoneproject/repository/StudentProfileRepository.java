package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends CrudRepository<StudentProfile, Integer> {


    @Query("select sp from StudentProfile sp where sp.customer.customerId = :customerId")
    Iterable<StudentProfile> findByCustomerId(Integer customerId);
}
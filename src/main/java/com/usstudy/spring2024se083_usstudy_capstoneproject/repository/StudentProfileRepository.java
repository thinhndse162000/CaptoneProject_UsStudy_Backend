package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {


    @Query("select sp from StudentProfile sp where sp.customer.customerId = :customerId")
    List<StudentProfile> findByCustomerId(Integer customerId);
}
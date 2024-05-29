package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationFormRepository extends JpaRepository<RegistrationForm, Integer> {

    @Query("select sp from RegistrationForm sp where sp.customer.customerId = :customerId")
    List<RegistrationForm> findByCustomerId(Integer customerId);

    @Query("select sp from RegistrationForm sp where sp.consultant.consultantId = :consultantId")
    List<RegistrationForm> findByConsultantId(Integer consultantId);
    @Query("Select rf from RegistrationForm rf " +
            "ORDER BY rf.createDate DESC")
    List<RegistrationForm> getAllByCreateDate();
}

package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationFormRepository extends CrudRepository<RegistrationForm,Integer> {

    @Query("select sp from RegistrationForm sp where sp.customerId = :customerId")
    Iterable<RegistrationForm> findByCustomerId(Integer customerId);

    @Query("select sp from RegistrationForm sp where sp.consultantId = :consultantId")
    Iterable<RegistrationForm> findByConsultantId(Integer consultantId);
}

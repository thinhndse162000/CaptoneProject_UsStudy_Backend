package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends CrudRepository<Consultant, Integer> {

    @Query("select sp from Consultant sp where sp.email = :email")
    Consultant getCustomerByEmail(String email);
}

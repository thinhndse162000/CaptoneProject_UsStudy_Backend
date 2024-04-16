package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Integer> {

    @Query("select sp from Consultant sp where sp.email = :email")
    Consultant getCustomerByEmail(String email);
    @Query("SELECT c FROM Consultant c " +
            "WHERE (:#{#req.userName} is null OR c.userName like %:#{#req.userName}%) " +
            "AND (:#{#req.email} is null OR c.email like %:#{#req.email}%) " +
            "AND (:#{#req.introduction} is null OR c.introduction like %:#{#req.introduction}%) " +
            "AND (:#{#req.education} is null OR c.education like %:#{#req.education}%) " +
            "AND (:#{#req.specialize} is null OR c.specialize like %:#{#req.specialize})")
    List<Consultant> getConsultantFilter(@Param(value = "req")ConsultantFilterRequest request);
}

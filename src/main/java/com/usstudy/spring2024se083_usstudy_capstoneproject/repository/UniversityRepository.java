package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {


    @Query("select sp from University sp where sp.universityTypeId = :typeId")
    List<University> getUniversityByUniversityTypeId(Integer typeId);

    @Query("select sp from University sp where sp.stateId = :typeId")
    List<University> getUniversityByStateId(Integer typeId);
}

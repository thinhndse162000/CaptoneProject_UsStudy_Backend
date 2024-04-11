package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.UniversityFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {


    @Query("select sp from University sp where sp.universityType.universityTypeId = :typeId")
    List<University> getUniversityByUniversityTypeId(Integer typeId);

    @Query("select sp from University sp where sp.state.stateId = :typeId")
    List<University> getUniversityByStateId(Integer typeId);

    @Query("SELECT u FROM University u"
            + " WHERE (:#{#req.universityName} is null OR u.universityName like %:#{#req.universityName}%) "
            + " AND (:#{#req.tuition} is null OR u.tuition = :#{#req.tuition})"
            + " AND (:#{#req.description} is null OR u.description like %:#{#req.description}%)"
    )
    List<University> getUniversityByRequest(@Param(value = "req") UniversityFilterRequest req);
}

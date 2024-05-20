package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProfileScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileScoreRepository extends JpaRepository<ProfileScore,Integer> {
    @Query("select sum(p.score) from ProfileScore p " +
            "where p.schoolProfile.schoolProfileId = :schoolProfileId")
    float getSumScoreBySchoolProfileId(Integer schoolProfileId);
    @Query("select count(p.profileScoreId) from ProfileScore p " +
            "where p.schoolProfile.schoolProfileId = :schoolProfileId")
    Integer countProfileScoreBySchoolProfileId(Integer schoolProfileId);
}

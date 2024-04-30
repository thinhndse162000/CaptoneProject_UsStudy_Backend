package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyStageRepository extends JpaRepository<ApplyStage, Integer> {
    ApplyStage getApplyStageByProgramApplicationProgramApplicationIdAndStatus(Integer programApplicationId,Integer status);
}

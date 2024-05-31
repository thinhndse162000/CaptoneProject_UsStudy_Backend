package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer> {
    @Query("Select d from Document d " +
            "WHERE d.programApplication.programApplicationId = :id " +
            "ORDER BY d.updateDate DESC")
    List<Document> getAllByProgramApplicationProgramApplicationId(Integer id);
}

package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramCertificateRepository extends JpaRepository<ProgramCertificate, Integer> {
    List<ProgramCertificate> getAllByProgramProgramId(Integer id);
}

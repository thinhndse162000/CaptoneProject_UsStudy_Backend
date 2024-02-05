package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FileUpload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends CrudRepository<FileUpload,Integer> {
}

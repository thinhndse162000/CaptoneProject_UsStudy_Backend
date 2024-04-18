package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StudentProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UploadFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentProfileMapper {
    StudentProfileMapper INSTANCE= Mappers.getMapper(StudentProfileMapper.class);
    @Mapping(target = "customerId",source = "studentProfile.customer.customerId")
    @Mapping(target = "fileUploads",source = "studentProfile.fileUploads",qualifiedByName = "MapFile")
    StudentProfileDto toDto(StudentProfile studentProfile);
    @Named("MapFile")
    default List<UploadFile> mapFile(List<UploadFile> uploadFiles){
        List<UploadFile> list=uploadFiles;
        for (UploadFile u:list) {
            u.setStudentProfile(null);
        }
        return list;
    }
    @Mapping(target = "customer",source = "customerId",qualifiedByName = "MapCustomer")
    StudentProfile toEntity(StudentProfileDto studentProfileDto);
    @Named("MapCustomer")
    default Customer mapCustomer(Integer id){
        Customer customer=new Customer();
        customer.setCustomerId(id);
        return customer;
    }
}

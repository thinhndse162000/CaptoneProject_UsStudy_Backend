package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StudentProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UploadFileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UploadFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface StudentProfileMapper {
    StudentProfileMapper INSTANCE= Mappers.getMapper(StudentProfileMapper.class);
    @Mapping(target = "customerId",source = "studentProfile.customer.customerId")
    @Mapping(target = "fileUploads",source = "studentProfile.fileUploads",qualifiedByName = "MapFile")
    StudentProfileDto toDto(StudentProfile studentProfile);
    @Named("MapFile")
    default List<UploadFileDto> mapFile(List<UploadFile> uploadFiles){
        if (uploadFiles!=null){
            List<UploadFileDto> list=uploadFiles.stream().map(UploadFileMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());
            return list;
        }
        return null;
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

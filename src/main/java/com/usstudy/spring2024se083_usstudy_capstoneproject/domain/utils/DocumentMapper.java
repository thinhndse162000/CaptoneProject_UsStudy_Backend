package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.DocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Document;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.DocumentType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {
    DocumentMapper INSTANCE= Mappers.getMapper(DocumentMapper.class);
    @Mapping(target = "programApplicationId",source = "document.programApplication.programApplicationId")
    @Mapping(target = "documentTypeDto",source = "document.documentType",qualifiedByName = "MapDocumentTypeDto")
    DocumentDto toDto(Document document);
    @Mapping(target = "programApplication",source = "programApplicationId",qualifiedByName = "MapProgramApplication")
    @Mapping(target = "documentType",source = "documentTypeId",qualifiedByName = "MapDocumentType")
    Document toEntity(DocumentRequest documentRequest);
    @Named("MapDocumentTypeDto")
    default DocumentTypeDto mapDocumentTypeDto(DocumentType documentType){
        if (documentType==null)
            return null;
        return DocumentTypeMapper.INSTANCE.toDto(documentType);
    }
    @Named("MapProgramApplication")
    default ProgramApplication mapProgramApplication(Integer id){
        ProgramApplication programApplication=new ProgramApplication();
        programApplication.setProgramApplicationId(id);
        return programApplication;
    }
    @Named("MapDocumentType")
    default DocumentType mapDocumentType(Integer id){
        DocumentType documentType=new DocumentType();
        documentType.setDocumentTypeId(id);
        return documentType;
    }
}

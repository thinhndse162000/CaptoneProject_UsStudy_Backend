package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramDocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDocumentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.DocumentType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramDocumentMapper {
    ProgramDocumentMapper INSTANCE= Mappers.getMapper(ProgramDocumentMapper.class);
    @Mapping(target = "programId",source = "programDocument.program.programId")
    @Mapping(target = "documentTypeDto",source = "programDocument.documentType",qualifiedByName = "MapDocumentTypeDto")
    ProgramDocumentDto toDto(ProgramDocument programDocument);
    @Mapping(target = "program",source = "programId",qualifiedByName = "MapProgram")
    @Mapping(target = "documentType",source = "documentTypeId",qualifiedByName = "MapDocumentType")
    ProgramDocument toEntity(ProgramDocumentRequest programDocumentRequest);
    @Named("MapProgram")
    default Program mapProgram(Integer id){
        Program program=new Program();
        program.setProgramId(id);
        return program;
    }
    @Named("MapDocumentType")
    default DocumentType mapDocumentType(Integer id){
        DocumentType documentType=new DocumentType();
        documentType.setDocumentTypeId(id);
        return documentType;
    }
    @Named("MapDocumentTypeDto")
    default DocumentTypeDto mapDocumentTypeDto(DocumentType documentType){
        if (documentType==null)
            return null;
        return DocumentTypeMapper.INSTANCE.toDto(documentType);
    }
}

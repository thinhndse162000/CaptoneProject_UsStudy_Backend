package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.DocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Document;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.DocumentMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.DocumentRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.DocumentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    @Override
    public List<DocumentDto> getAll() {
        return documentRepository.findAll()
                .stream().map(DocumentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentDto getById(Integer id) {
        return DocumentMapper.INSTANCE.toDto(
                documentRepository.findById(id)
                        .orElseThrow(() -> new NullPointerException("No Document id - "+id))
        );
    }

    @Override
    public DocumentDto saveDocument(DocumentRequest documentRequest, Integer id) {
        if (id!=null){
            Document document=documentRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("No Document id - "+id));
            MergeRequest.mergeIgnoreNullValue(documentRequest,document);
            return DocumentMapper.INSTANCE.toDto(
                    documentRepository.save(document)
            );
        }
        return DocumentMapper.INSTANCE.toDto(
                documentRepository.save(
                        DocumentMapper.INSTANCE.toEntity(documentRequest)
                )
        );
    }

    @Override
    public List<DocumentDto> getByProgramApplicationId(Integer id) {
        return documentRepository.getAllByProgramApplicationProgramApplicationId(id)
                .stream().map(DocumentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}

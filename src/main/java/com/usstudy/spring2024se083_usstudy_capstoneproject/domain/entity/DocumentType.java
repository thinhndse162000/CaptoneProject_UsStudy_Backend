package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id")
    private Integer documentTypeId;
    @Column(name = "type_name")
    private String typeName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
    @JsonBackReference
    private List<Document> documents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
    @JsonBackReference
    private List<ProgramDocument> programDocuments;
}

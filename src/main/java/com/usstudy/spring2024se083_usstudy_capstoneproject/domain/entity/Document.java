package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Integer documentId;
    @Column(name = "file_name")
    private String file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_application_id", nullable = false)
    @JsonManagedReference
    private ProgramApplication programApplication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id", nullable = false)
    @JsonManagedReference
    private DocumentType documentType;
}

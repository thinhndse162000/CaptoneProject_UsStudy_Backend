package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

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
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id")
    private Integer documentTypeId;
    @Column(name = "type_name")
    private String typeName;
}

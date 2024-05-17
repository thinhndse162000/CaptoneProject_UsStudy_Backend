package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {
    private Integer documentId;
    private String file;
    private Integer programApplicationId;
    private DocumentTypeDto documentTypeDto;
}

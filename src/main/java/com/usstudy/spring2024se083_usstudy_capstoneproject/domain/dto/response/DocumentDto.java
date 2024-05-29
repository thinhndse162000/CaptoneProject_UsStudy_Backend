package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.google.type.DateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {
    private Integer documentId;
    private String file;
    private Integer programApplicationId;
    private DocumentTypeDto documentTypeDto;
    private Date updateDate;
    private Integer status;
}

package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramTypeDto {
    private Integer programTypeId;
    private String typeName;
    private String description;
}

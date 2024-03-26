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
public class MajorDto {
    private Integer majorId;
    private String majorName;
    private String description;
    private String img;
}

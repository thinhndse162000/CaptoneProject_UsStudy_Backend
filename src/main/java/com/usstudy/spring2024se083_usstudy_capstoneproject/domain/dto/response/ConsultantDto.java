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
public class ConsultantDto {

    @Column(name = "consultant_id")
    private Integer consultantId;
    @Column(name = "username")
    private String userName;
    private String email;
    private String password;
    private String description;
}

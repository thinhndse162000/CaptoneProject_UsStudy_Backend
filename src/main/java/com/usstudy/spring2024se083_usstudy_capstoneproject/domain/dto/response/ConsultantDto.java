package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ConsultantMapper;
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
    private String introduction;
    private String education;
    private String specialize;
    private String img;
    
    public static ConsultantDto convert(Consultant consultant) {
        return ConsultantMapper.INSTANT.consultantToConsultantDto(consultant);
    }
}

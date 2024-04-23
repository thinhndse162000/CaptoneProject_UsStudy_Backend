package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultantRequest {
    private String userName;
    private String email;
    private String password;
    private String introduction;
    private String education;
    private List<String> specialize;
    private String img;
}

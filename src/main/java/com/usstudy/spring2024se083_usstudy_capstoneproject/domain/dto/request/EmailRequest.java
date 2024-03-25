package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailRequest {
    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;
    private String token;
}

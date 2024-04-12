package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFeeDto {
    private Integer applicationFeeId;
    private Integer programFeeId;
    private Integer programApplicationId;
    private int amount;
}

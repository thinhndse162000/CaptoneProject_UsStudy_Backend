package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.UniversityMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDto {
    private Integer universityId;
    private String universityName;
    private Float tuition;
    private String description;

    private Integer universityTypeId;

    private Integer stateId;
    private Integer staffId;
    private String img;
    private String slogan;
    private String website;
    private String email;
    private float admission_rate;

//    public static UniversityDto convert(University university) {
//        return UniversityMapper.INSTANCE.universityToUniversityDto(university);
//    }
}

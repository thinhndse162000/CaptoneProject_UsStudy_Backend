package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDto {
    private Integer programId;
    private String nameProgram;
    private String status;
    private Date createDate;
    private Date modifiedDate;
    private Integer modifier;
    private String duration;
    private String description;
    private String tuition;
    private String level;
    private String img;
    private String responsibilities;
    private String requirement;
    private Integer universityId;
    private String fileDownload;

    private Integer majorId;

    private Integer semesterId;

    private Integer programTypeId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private University university;
    private List<ProgramStageDto> programStageDtos;

    public static ProgramDto convert(Program program) {
        return ProgramMapper.INSTANCE.programToProgramDto(program);
    }
}

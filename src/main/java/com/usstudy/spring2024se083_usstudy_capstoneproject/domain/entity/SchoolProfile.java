package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SchoolProfile")
@Table(name = "SchoolProfile")
public class SchoolProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_profile_id")
    private Integer schoolProfileId;
    private String semester;
    @Column(name = "school_grade")
    private Integer schoolGrade;
    private String img;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_profile_id", nullable = false)
    @JsonManagedReference
    private StudentProfile studentProfile;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "schoolProfile")
    @JsonBackReference
    private List<ProfileScore> profileScores;
}

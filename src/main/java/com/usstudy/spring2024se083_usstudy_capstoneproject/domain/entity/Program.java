package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Program implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Integer programId;
    @Column(name = "name_program")
    private String nameProgram;
    private String status;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "modified_date")
    private Date modifiedDate;
    private Integer modifier;
    private String duration; //in days or months?
    private String description;
    private float tuition;
    private String level;
    private String img;
    private String responsibilities;
    private String requirement;

    //FK university here
//    @Column(name = "university_id")
//    private Integer universityId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private University university;
    //Fk Major here
//    @Column(name = "major_id")
//    private Integer majorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id", nullable = false)
    @JsonManagedReference
    private Major major;
    //FK Semester here
//    @Column(name = "semester_id")
//    private Integer semesterId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false)
    @JsonManagedReference
    private Semester semester;
    //FK Program Type here
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_type_id", nullable = false)
    @JsonManagedReference
    private ProgramType programType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program")
    @JsonBackReference
    private List<ProgramFee> programFees;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program")
    @JsonBackReference
    private List<ProgramStage> programStages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program")
    @JsonBackReference
    private List<ProgramApplication> programApplications;
}

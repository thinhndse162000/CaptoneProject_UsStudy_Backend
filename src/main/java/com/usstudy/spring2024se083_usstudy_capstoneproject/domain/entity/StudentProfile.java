package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "studentProfile")
public class StudentProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_profile_id")
    private Integer studentProfileId;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String address;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "study_process")
    private String studyProcess;
    private String img;
    @Column(name = "english_level")
    private String englishLevel;
    private String grade;
    //    @Column(name = "customer_id")
//    private Integer customerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonManagedReference
    @JsonIgnore
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentProfile")
    @JsonBackReference
    private List<ProgramApplication> programApplications;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentProfile")
    @JsonBackReference
    private List<UploadFile> fileUploads;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentProfile")
    @JsonBackReference
    private List<EnglishScore> englishScores;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentProfile")
    @JsonBackReference
    private  List<SchoolProfile> schoolProfiles;
}

package com.recruitment.recruitmentsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StudyType studyType;

    @Enumerated(EnumType.STRING)
    private FieldOfStudy fieldOfStudy;

    @Enumerated(EnumType.STRING)
    private Status status;

    private boolean isPaid;

    @OneToOne
    @JsonBackReference
    private Candidate candidate;

}

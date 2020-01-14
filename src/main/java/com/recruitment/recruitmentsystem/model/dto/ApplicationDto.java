package com.recruitment.recruitmentsystem.model.dto;

import com.recruitment.recruitmentsystem.model.FieldOfStudy;
import com.recruitment.recruitmentsystem.model.StudyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
    private Long id;
    private StudyType studyType;
    private FieldOfStudy fieldOfStudy;
}

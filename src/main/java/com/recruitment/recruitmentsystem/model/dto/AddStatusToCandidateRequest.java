package com.recruitment.recruitmentsystem.model.dto;


import com.recruitment.recruitmentsystem.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStatusToCandidateRequest {
    private Long candidateId;
    private Long employeeId;
    private Long applicationId;
    private Status status;
}

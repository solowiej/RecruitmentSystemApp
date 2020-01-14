package com.recruitment.recruitmentsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMoneyToCandidateRequest {
    private Long candidateId;

    private Long balance;
}

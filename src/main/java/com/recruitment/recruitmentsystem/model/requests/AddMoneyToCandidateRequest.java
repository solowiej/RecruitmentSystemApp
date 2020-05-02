package com.recruitment.recruitmentsystem.model.requests;

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

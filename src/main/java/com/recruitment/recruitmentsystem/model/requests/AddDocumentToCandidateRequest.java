package com.recruitment.recruitmentsystem.model.requests;

import com.recruitment.recruitmentsystem.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDocumentToCandidateRequest {
    private Long candidateId;
    private DocumentType documentType;
}

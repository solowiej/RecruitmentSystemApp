package com.recruitment.recruitmentsystem.model.dto;

import com.recruitment.recruitmentsystem.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {
    private Long id;
    private DocumentType documentType;
}

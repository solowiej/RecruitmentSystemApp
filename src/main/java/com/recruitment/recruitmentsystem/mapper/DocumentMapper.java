package com.recruitment.recruitmentsystem.mapper;


import com.recruitment.recruitmentsystem.model.Document;
import com.recruitment.recruitmentsystem.model.dto.AddDocumentToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.DocumentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface DocumentMapper {
    Document createDocumentFromDto(DocumentDto dto);

    @Mappings(value = {
            @Mapping(source = "documentType", target = "documentType"),
            @Mapping(target = "id", ignore = true)
    })
    Document createDocumentFromDto(AddDocumentToCandidateRequest dto);
}

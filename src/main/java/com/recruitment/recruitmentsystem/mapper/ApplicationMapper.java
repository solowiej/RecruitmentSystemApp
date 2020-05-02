package com.recruitment.recruitmentsystem.mapper;

import com.recruitment.recruitmentsystem.model.Application;
import com.recruitment.recruitmentsystem.model.requests.AddApplicationToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.ApplicationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    Application createApplicationFromDto(ApplicationDto dto);

    @Mappings(value = {
            @Mapping(source = "studyType", target = "studyType"),
            @Mapping(source = "fieldOfStudy", target = "fieldOfStudy"),
            @Mapping(target = "id", ignore = true)
    })
    Application createApplicationFromDto(AddApplicationToCandidateRequest dto);
}

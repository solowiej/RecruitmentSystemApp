package com.recruitment.recruitmentsystem.mapper;


import com.recruitment.recruitmentsystem.model.Candidate;
import com.recruitment.recruitmentsystem.model.dto.CandidateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate createCandidateFromDto(CandidateDto dto);

}

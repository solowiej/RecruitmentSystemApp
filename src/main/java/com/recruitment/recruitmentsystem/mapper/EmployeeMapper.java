package com.recruitment.recruitmentsystem.mapper;


import com.recruitment.recruitmentsystem.model.Employee;
import com.recruitment.recruitmentsystem.model.dto.EmployeeDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee createEmployeeFromDto(EmployeeDto dto);
}

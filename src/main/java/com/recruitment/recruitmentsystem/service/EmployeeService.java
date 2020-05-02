package com.recruitment.recruitmentsystem.service;


import com.recruitment.recruitmentsystem.mapper.EmployeeMapper;
import com.recruitment.recruitmentsystem.model.Application;
import com.recruitment.recruitmentsystem.model.Candidate;
import com.recruitment.recruitmentsystem.model.Employee;
import com.recruitment.recruitmentsystem.model.requests.AddStatusToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.EmployeeDto;
import com.recruitment.recruitmentsystem.repository.ApplicationRepository;
import com.recruitment.recruitmentsystem.repository.CandidateRepository;
import com.recruitment.recruitmentsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeMapper;
    private CandidateRepository candidateRepository;
    private ApplicationRepository applicationRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeMapper, CandidateRepository candidateRepository,
                           ApplicationRepository applicationRepository) {
        this.employeeRepository = employeeRepository;
        this.employeMapper = employeMapper;
        this.candidateRepository = candidateRepository;
        this.applicationRepository = applicationRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        }
        throw new EntityNotFoundException("employee, id:" + employeeId);
    }

    public Long save(EmployeeDto dto) {
        Employee employee = employeMapper.createEmployeeFromDto(dto);

        return employeeRepository.save(employee).getId();
    }

    public void update(EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getId());
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            if (employee.getName() != null) {
                employee.setName(employeeDto.getName());
            }
            if (employee.getSurname() != null) {
                employee.setSurname(employeeDto.getSurname());
            }
            if (employee.getEmployeeNumber() != null) {
                employee.setEmployeeNumber(employeeDto.getEmployeeNumber());
            }

            employeeRepository.save(employee);
            return;
        }
        throw new EntityNotFoundException("employee, id:" + employeeDto.getId());
    }

    public void delete(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("employee, id:" + id);
    }

    public Long addStatusToCandidate(AddStatusToCandidateRequest addStatusToCandidateRequest) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(addStatusToCandidateRequest.getCandidateId());
        Optional<Employee> optionalEmployee = employeeRepository.findById(addStatusToCandidateRequest.getEmployeeId());
        Optional<Application> optionalApplication = applicationRepository.findById(addStatusToCandidateRequest.getApplicationId());

        if (optionalCandidate.isPresent() && optionalEmployee.isPresent() && optionalApplication.isPresent()) {
            Candidate candidate = optionalCandidate.get();
            Employee employee = optionalEmployee.get();

            for (Application application : candidate.getApplications()) {
                if (application.getId().equals(addStatusToCandidateRequest.getApplicationId())) {
                    application.setStatus(addStatusToCandidateRequest.getStatus());
                    application.setCandidate(candidate);
                    applicationRepository.save(application);
                    candidateRepository.save(candidate);
                }
            }
            return employeeRepository.save(employee).getId();
        }
        throw new EntityNotFoundException("employee, id:" + addStatusToCandidateRequest.getEmployeeId());
    }


}

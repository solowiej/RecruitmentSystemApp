package com.recruitment.recruitmentsystem.controller;


import com.recruitment.recruitmentsystem.model.Employee;
import com.recruitment.recruitmentsystem.model.dto.AddStatusToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.EmployeeDto;
import com.recruitment.recruitmentsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getEmployeeList() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(
            @PathVariable("id") Long employeeId) {
        return employeeService.getById(employeeId);
    }

    @PutMapping
    public Long putEmployee(EmployeeDto employee) {
        return employeeService.save(employee);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void postEmployee(EmployeeDto employee) {
        employeeService.update(employee);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }

    @PostMapping("/addStatus")
    public Long addStatus(AddStatusToCandidateRequest addStatusToCandidateRequest) {
        return employeeService.addStatusToCandidate(addStatusToCandidateRequest,
                addStatusToCandidateRequest.getApplicationId());
    }

}

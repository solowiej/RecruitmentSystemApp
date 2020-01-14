package com.recruitment.recruitmentsystem.controller;


import com.recruitment.recruitmentsystem.model.Candidate;
import com.recruitment.recruitmentsystem.model.dto.AddApplicationToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.AddDocumentToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.AddMoneyToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.CandidateDto;
import com.recruitment.recruitmentsystem.service.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/candidate")
@AllArgsConstructor
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping()
    public List<Candidate> getCandidateList() {
        return candidateService.getAll();
    }

    @GetMapping("/{id}")
    public Candidate getById(
            @PathVariable("id") Long candidateId) {
        return candidateService.getById(candidateId);
    }

    @PutMapping
    public Long putCandidate(CandidateDto candidate) {
        return candidateService.save(candidate);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void postCandidate(CandidateDto candidate) {
        candidateService.update(candidate);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id) {
        candidateService.delete(id);
    }

    @PostMapping("/document")
    public Long addDocument(AddDocumentToCandidateRequest addDocumentToCandidate) {
        return candidateService.addDocumentToCandidate(addDocumentToCandidate);
    }
    @PostMapping("/application")
    public Long addApplication(AddApplicationToCandidateRequest addApplicationToCandidate) {
        return candidateService.addApplicationToCandidate(addApplicationToCandidate);
    }
    @PostMapping("/addMoney")
    public Long addMoney(AddMoneyToCandidateRequest addMoneyToCandidateRequest) {
        return candidateService.addMoneyToCandidate(addMoneyToCandidateRequest);
    }
}

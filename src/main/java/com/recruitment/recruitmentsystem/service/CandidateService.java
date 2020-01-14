package com.recruitment.recruitmentsystem.service;


import com.recruitment.recruitmentsystem.mapper.ApplicationMapper;
import com.recruitment.recruitmentsystem.mapper.CandidateMapper;
import com.recruitment.recruitmentsystem.mapper.DocumentMapper;
import com.recruitment.recruitmentsystem.model.Application;
import com.recruitment.recruitmentsystem.model.Candidate;
import com.recruitment.recruitmentsystem.model.Document;
import com.recruitment.recruitmentsystem.model.StudyType;
import com.recruitment.recruitmentsystem.model.dto.AddApplicationToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.AddDocumentToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.AddMoneyToCandidateRequest;
import com.recruitment.recruitmentsystem.model.dto.CandidateDto;
import com.recruitment.recruitmentsystem.repository.ApplicationRepository;
import com.recruitment.recruitmentsystem.repository.CandidateRepository;
import com.recruitment.recruitmentsystem.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    private CandidateRepository candidateRepository;
    private CandidateMapper candidateMapper;
    private ApplicationRepository applicationRepository;
    private DocumentRepository documentRepository;
    private ApplicationMapper aplicationMapper;
    private DocumentMapper documentMapper;


    @Autowired
    public CandidateService(CandidateRepository candidateRepository, CandidateMapper candidateMapper,
                            ApplicationRepository applicationRepository, DocumentRepository documentRepository,
                            ApplicationMapper aplicationMapper, DocumentMapper documentMapper) {
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
        this.applicationRepository = applicationRepository;
        this.documentRepository = documentRepository;
        this.aplicationMapper = aplicationMapper;
        this.documentMapper = documentMapper;
    }

    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }


    public Candidate getById(Long candidateId) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(candidateId);

        if (optionalCandidate.isPresent()) {
            return optionalCandidate.get();
        }
        throw new EntityNotFoundException("candidate, id:" + candidateId);
    }

    public Long save(CandidateDto dto) {
        Candidate candidate = candidateMapper.createCandidateFromDto(dto);

        return candidateRepository.save(candidate).getId();
    }

    public void update(CandidateDto candidateDto) {

        Optional<Candidate> optionalCandidate = candidateRepository.findById(candidateDto.getId());
        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();

            if (candidateDto.getName() != null) {
                candidate.setName(candidateDto.getName());
            }
            if (candidateDto.getSurname() != null) {
                candidate.setSurname(candidateDto.getSurname());
            }
            if (candidateDto.getPersonalIdentificationNumber() != null) {
                candidate.setPersonalIdentificationNumber(candidateDto.getPersonalIdentificationNumber());
            }
            if (candidateDto.getDateOfBirth() != null) {
                candidate.setDateOfBirth(candidateDto.getDateOfBirth());
            }

            candidateRepository.save(candidate);
            return;
        }
        throw new EntityNotFoundException("candidate, id:" + candidateDto.getId());
    }

    public void delete(Long id) {
        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("candidate, id:" + id);
    }


    public Long addDocumentToCandidate(AddDocumentToCandidateRequest addDocumentToCandidateRequest) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(addDocumentToCandidateRequest.getCandidateId());

        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();

            Document document = documentMapper.createDocumentFromDto(addDocumentToCandidateRequest);
            document.setCandidate(candidate);

            return documentRepository.save(document).getId();

        }
        throw new EntityNotFoundException("candidate, id:" + addDocumentToCandidateRequest.getCandidateId());
    }

    public Long addApplicationToCandidate(AddApplicationToCandidateRequest addApplicationToCandidateRequest) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(addApplicationToCandidateRequest.getCandidateId());
        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();

            Long fees = 0L;
            if (addApplicationToCandidateRequest.getStudyType().equals(StudyType.FULLTIME)) {
                fees = 85L;
            } else if (addApplicationToCandidateRequest.getStudyType().equals(StudyType.PARTTIME)) {
                fees = 85L + 2500L;
            }

            if (optionalCandidate.get().getDocument().size() == 4 && optionalCandidate.get().getBalance() > fees) {
                candidate.setBalance(optionalCandidate.get().getBalance() - fees);
                candidateRepository.save(candidate);

                Application application = aplicationMapper.createApplicationFromDto(addApplicationToCandidateRequest);
                application.setPaid(true);
                application.setCandidate(candidate);

                return applicationRepository.save(application).getId();

            } else {
                throw new EntityNotFoundException(". There is no document or not enough money in the account");
            }

        }
        throw new EntityNotFoundException("candidate, id:" + addApplicationToCandidateRequest.getCandidateId());
    }

    public Long addMoneyToCandidate(AddMoneyToCandidateRequest addMoneyToCandidateRequest) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(addMoneyToCandidateRequest.getCandidateId());
        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();

            candidate.setBalance(addMoneyToCandidateRequest.getBalance());

            return candidateRepository.save(candidate).getId();

        }
        throw new EntityNotFoundException("candidate, id:" + addMoneyToCandidateRequest.getCandidateId());
    }


}

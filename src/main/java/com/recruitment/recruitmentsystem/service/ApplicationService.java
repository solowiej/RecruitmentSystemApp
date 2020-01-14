package com.recruitment.recruitmentsystem.service;


import com.recruitment.recruitmentsystem.mapper.ApplicationMapper;
import com.recruitment.recruitmentsystem.model.Application;
import com.recruitment.recruitmentsystem.model.dto.ApplicationDto;
import com.recruitment.recruitmentsystem.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private ApplicationMapper applicationMapper;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository, ApplicationMapper applicationMapper) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
    }

    public List<Application> getAll() {
        return applicationRepository.findAll();
    }


    public Application getById(Long applicationId) {
        Optional<Application> optionalApplication = applicationRepository.findById(applicationId);

        if (optionalApplication.isPresent()) {
            return optionalApplication.get();
        }
        throw new EntityNotFoundException("application, id:" + applicationId);
    }

    public Long save(ApplicationDto dto) {
        Application application = applicationMapper.createApplicationFromDto(dto);

        return applicationRepository.save(application).getId();
    }

    public void update(ApplicationDto applicationDto) {

        Optional<Application> optionalApplication = applicationRepository.findById(applicationDto.getId());
        if (optionalApplication.isPresent()) {
            Application application = optionalApplication.get();

            if (applicationDto.getFieldOfStudy() != null) {
                application.setStudyType(applicationDto.getStudyType());
            }
            if (application.getFieldOfStudy() != null) {
                application.setFieldOfStudy(applicationDto.getFieldOfStudy());
            }

            applicationRepository.save(application);
            return;
        }
        throw new EntityNotFoundException("application, id:" + applicationDto.getId());
    }

    public void delete(Long id) {
        if (applicationRepository.existsById(id)) {
            applicationRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("application, id:" + id);
    }

}

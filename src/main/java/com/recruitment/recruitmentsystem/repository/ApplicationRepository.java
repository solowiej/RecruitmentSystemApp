package com.recruitment.recruitmentsystem.repository;

import com.recruitment.recruitmentsystem.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}


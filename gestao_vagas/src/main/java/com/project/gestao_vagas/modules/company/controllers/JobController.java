package com.project.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gestao_vagas.modules.company.dto.CreateJobDTO;
import com.project.gestao_vagas.modules.company.entities.JobEntity;
import com.project.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    
    @Autowired
    private CreateJobUseCase createJobUseCase;


    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJObDTO, HttpServletRequest request){

        var companyId = request.getAttribute("company_id");
        // jobEntity.setCompanyId(UUID.fromString(companyId.toString()));

        var jobEntity = JobEntity.builder()
        .benefits(createJObDTO.getBenefits())
        .companyId(UUID.fromString(companyId.toString()))
        .description(createJObDTO.getDescription())
        .level(createJObDTO.getLevel())
        .build();
        
        return this.createJobUseCase.execute(jobEntity);
    }
}

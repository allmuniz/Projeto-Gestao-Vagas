package com.project.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gestao_vagas.modules.company.dto.CreateJobDTO;
import com.project.gestao_vagas.modules.company.entities.JobEntity;
import com.project.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company/job")
public class JobController {
    
    @Autowired
    private CreateJobUseCase createJobUseCase;


    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    @Tag(name = "Jobs", description = "Information of jobs")
    @Operation(summary = "Vacancy registration", 
    description = "This function is responsible for registering vacancies within the company.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = JobEntity.class))
        })
    })
    @SecurityRequirement(name = "jwt_auth")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJObDTO, HttpServletRequest request){

        var companyId = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder()
        .benefits(createJObDTO.getBenefits())
        .companyId(UUID.fromString(companyId.toString()))
        .description(createJObDTO.getDescription())
        .level(createJObDTO.getLevel())
        .build();
        
        return this.createJobUseCase.execute(jobEntity);
    }
}
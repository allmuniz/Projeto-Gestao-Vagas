package com.project.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestao_vagas.modules.company.entities.JobEntity;
import com.project.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;
    
    @SuppressWarnings("null")
    public JobEntity execute(JobEntity jobEntity){
        
        return this.jobRepository.save(jobEntity);
    }
}
    
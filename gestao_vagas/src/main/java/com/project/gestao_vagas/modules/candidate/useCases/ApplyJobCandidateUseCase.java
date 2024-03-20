package com.project.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestao_vagas.exceptions.JobNotFoundException;
import com.project.gestao_vagas.exceptions.UserNotFoundException;
import com.project.gestao_vagas.modules.candidate.repositories.ApplyJobRepository;
import com.project.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import com.project.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;
    
    public void execute(UUID idCandidate, UUID idJob){
        
        this.candidateRepository.findById(idCandidate)
        .orElseThrow(() ->{
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(idJob)
        .orElseThrow(() ->{
            throw new JobNotFoundException();
        });
    }
}

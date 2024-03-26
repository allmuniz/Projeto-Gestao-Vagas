package com.project.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestao_vagas.exceptions.UserNotFoundException;
import com.project.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import com.project.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class ProfileCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;
    
    public ProfileCandidateResponseDTO execute(UUID idCandidate){
        
        @SuppressWarnings("null")
        var candidate = this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                            .id(candidate.getId())
                            .name(candidate.getName())
                            .username(candidate.getUsername())
                            .email(candidate.getEmail())
                            .description(candidate.getDescription())
                            .build();

                                
        return candidateDTO;
    }
}

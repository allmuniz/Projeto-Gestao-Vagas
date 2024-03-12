package com.project.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gestao_vagas.modules.candidate.CandidateEntity;
import com.project.gestao_vagas.modules.candidate.CandidateRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    @Autowired
    private CandidateRepository candidateRepository;
    
    @SuppressWarnings("null")
    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity){
       return this.candidateRepository.save(candidateEntity);
        
        
        // System.out.println("Candidato");
        // System.out.println(candidateEntity.getEmail());
    }
}
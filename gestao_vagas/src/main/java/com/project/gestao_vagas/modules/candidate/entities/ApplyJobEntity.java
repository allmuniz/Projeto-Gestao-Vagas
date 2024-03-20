package com.project.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import com.project.gestao_vagas.modules.company.entities.JobEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "apply_jobs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyJobEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", insertable = false, updatable = false)
    private CandidateEntity candidateEntity;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private JobEntity jobEntity;

    @Column(name = "candidate_id")
    private UUID candidateId;

    @Column(name = "job_id")
    private UUID jobId;
    
    @CreationTimestamp
    private LocalDateTime cratedAt;
}

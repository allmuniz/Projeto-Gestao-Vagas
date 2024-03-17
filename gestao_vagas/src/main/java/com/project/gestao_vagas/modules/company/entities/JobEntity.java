package com.project.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "job")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {    

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;
    
    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    private String description;

    @NotBlank(message =  "Este campo é obrigatorio")
    private String level;

    private String benefits;

    @CreationTimestamp
    private LocalDateTime crateadAt;
}

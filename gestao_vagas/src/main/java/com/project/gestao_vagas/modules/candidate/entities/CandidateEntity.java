package com.project.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Entity(name = "candidate")
public class CandidateEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaço")
    private String username;

    @Email(message = "O campo [e-mail] deve conter um e-mail valido")
    private String email;

    @Length(min = 6, max = 150, message = "A senha deve conter entre 6 e 15 caracteries")
    private String password;

    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime cratedAt;
}

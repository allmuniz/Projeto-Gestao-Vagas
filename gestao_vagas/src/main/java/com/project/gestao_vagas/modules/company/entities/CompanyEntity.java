package com.project.gestao_vagas.modules.company.entities;

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
@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não é valido")
    private String username;

    @Email(message = "O campo [e-mail] deve ser valido")
    private String email;

    @Length(min = 6, max = 15, message = "A senha deve conter de 6 a 15 caracteres")
    private String password;

    private String website;

    private String description;

    @CreationTimestamp
    private LocalDateTime crateadAt;
}

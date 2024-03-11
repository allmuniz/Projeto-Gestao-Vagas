package com.project.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class CandidateEntity {
    
    private UUID id;
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaço")
    private String username;

    @Email(message = "O campo [e-mail] deve conter um e-mail valido")
    private String email;

    @Length(min = 6, max = 15, message = "A senha deve conter entre 6 e 15 caracteries")
    private String password;
    private String description;
    private String curriculum;
    

    // public UUID getId() {
    //     return id;
    // }
    // public void setId(UUID id) {
    //     this.id = id;
    // }


    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }


    // public String getUsername() {
    //     return username;
    // }
    // public void setUsername(String username) {
    //     this.username = username;
    // }


    // public String getEmail() {
    //     return email;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }


    // public String getPassword() {
    //     return password;
    // }
    // public void setPassword(String password) {
    //     this.password = password;
    // }


    // public String getDescription() {
    //     return description;
    // }
    // public void setDescription(String description) {
    //     this.description = description;
    // }


    // public String getCurriculum() {
    //     return curriculum;
    // }
    // public void setCurriculum(String curriculum) {
    //     this.curriculum = curriculum;
    // }
}
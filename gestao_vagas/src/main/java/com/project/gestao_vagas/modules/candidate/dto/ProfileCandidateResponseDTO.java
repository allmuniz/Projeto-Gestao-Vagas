package com.project.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {
    
    private UUID id;

    @Schema(example = "Your name")
    private String name;
    
    @Schema(example = "Your username")
    private String username;

    @Schema(example = "youremail@email.com")
    private String email;

    @Schema(example = "Desenvolvedor Java")
    private String description;
}

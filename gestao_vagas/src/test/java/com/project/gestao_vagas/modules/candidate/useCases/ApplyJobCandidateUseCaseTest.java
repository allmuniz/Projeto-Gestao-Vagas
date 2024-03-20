package com.project.gestao_vagas.modules.candidate.useCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.gestao_vagas.exceptions.JobNotFoundException;
import com.project.gestao_vagas.exceptions.UserNotFoundException;
import com.project.gestao_vagas.modules.candidate.entities.CandidateEntity;
import com.project.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import com.project.gestao_vagas.modules.company.repositories.JobRepository;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {
    
    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;
    
    @Test
    @DisplayName("Shoud not be able to apply job with candidate not found")
    public void shoud_not_be_able_to_apply_job_with_candidate_not_found(){
        
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e, instanceOf(UserNotFoundException.class));
        }
    }

    @SuppressWarnings("null")
    @Test
    @DisplayName("Shoud not be able to apply job with job not found")
    public void shoud_not_be_able_to_apply_job_with_job_not_found(){

        var idCandidate = UUID.randomUUID();
        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));
        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e, instanceOf(JobNotFoundException.class));
        }
    }
}

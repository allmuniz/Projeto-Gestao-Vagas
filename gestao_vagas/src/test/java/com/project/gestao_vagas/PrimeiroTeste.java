package com.project.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimeiroTeste {
    
    @Test
    public void deve_calcular_dois_numeros(){
        var result = calculete(2, 3);
        assertEquals(result, 5);
    }


    public static int calculete(int num1, int num2){
        
        return num1 + num2;
    }
}

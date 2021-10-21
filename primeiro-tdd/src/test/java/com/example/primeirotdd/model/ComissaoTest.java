package com.example.primeirotdd.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class ComissaoTest {
    
    /**
     * 
     * Vendas abaixo de mil reais váo gerar
     * 10% de comissão. Já as vendas acima de mil reais, 
     * terá comissão de 15%
     */
    @Autowired
    Comissao comissao;

    @TestConfiguration
    static class ComissaoConfiguracao {
        @Bean
        public Comissao comissao(){
            return new Comissao();
        }
    }

    @Test
    public void deve_calcular_20_reais_de_comissao_para_venda_de_200(){
        
        // Arrange - Preparação
        double valorVenda = 200.0;
        double comissaoEsperada = 20.0;

        // Act - Ação/Execução
        double comissaoCalculada = comissao.calcular(valorVenda);

        // Assert - Confirmação
        Assertions.assertEquals(comissaoEsperada, comissaoCalculada);
    }

    @Test
    public void deve_calcular_150_reais_de_comissao_para_venda_de_1000(){
        
        // Arrange - Preparação
        double valorVenda = 1000.0;
        double comissaoEsperada = 150.0;

        // Act - Ação/Execução
        double comissaoCalculada = comissao.calcular(valorVenda);

        // Assert - Confirmação
        Assertions.assertEquals(comissaoEsperada, comissaoCalculada);
    }


}

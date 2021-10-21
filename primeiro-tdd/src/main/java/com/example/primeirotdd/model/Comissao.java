package com.example.primeirotdd.model;

public class Comissao {
    
    public double calcular(double valorVenda) {
        return (valorVenda < 1000.0) ? valorVenda * 0.1 : valorVenda * 0.15;
    }
}

package com.example.parcialweb.dto;

import java.time.LocalDate;

public class ContratoDTO {

    private Long id;
    private String identificador;
    private Double valor;
    private String nombreContratante;
    private String documentoContratante;
    private String nombreContratantista;
    private String documentoContratantista;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;

    public ContratoDTO() {
    }

    public ContratoDTO(Long id, String identificador, Double valor, String nombreContratante, 
                       String documentoContratante, String nombreContratantista, 
                       String documentoContratantista, LocalDate fechaInicial, LocalDate fechaFinal) {
        this.id = id;
        this.identificador = identificador;
        this.valor = valor;
        this.nombreContratante = nombreContratante;
        this.documentoContratante = documentoContratante;
        this.nombreContratantista = nombreContratantista;
        this.documentoContratantista = documentoContratantista;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public String getDocumentoContratante() {
        return documentoContratante;
    }

    public void setDocumentoContratante(String documentoContratante) {
        this.documentoContratante = documentoContratante;
    }

    public String getNombreContratantista() {
        return nombreContratantista;
    }

    public void setNombreContratantista(String nombreContratantista) {
        this.nombreContratantista = nombreContratantista;
    }

    public String getDocumentoContratantista() {
        return documentoContratantista;
    }

    public void setDocumentoContratantista(String documentoContratantista) {
        this.documentoContratantista = documentoContratantista;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}

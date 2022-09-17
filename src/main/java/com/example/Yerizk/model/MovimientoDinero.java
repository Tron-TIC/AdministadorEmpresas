package com.example.Yerizk.model;
import javax.persistence.*;

@Entity
@Table(name="MovimientoDinero")

public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="montoDinero")
    private String montoDinero;

    @Column(name="montoPositivo")
    private String montoPositivo;

    @Column(name="montoNegativo")
    private String montoNegativo;

    @Column(name="conceptoMovimiento")
    private String conceptoMovimiento;

    @Column(name="usuarioEncargado")
    private String usuarioEncargado;

    public MovimientoDinero(){}


    public MovimientoDinero(String montoDinero, String montoPositivo, String montoNegativo, String conceptoMovimiento, String usuarioEncargado) {
        this.montoDinero = montoDinero;
        this.montoPositivo = montoPositivo;
        this.montoNegativo = montoNegativo;
        this.conceptoMovimiento = conceptoMovimiento;
        this.usuarioEncargado = usuarioEncargado;
    }


    public String getMontoDinero() {
        return this.montoDinero;
    }

    public void setMontoDinero(String montoDinero) {
        this.montoDinero = montoDinero;
    }

    public String getMontoPositivo() {
        return this.montoPositivo;
    }

    public void setMontoPositivo(String montoPositivo) {
        this.montoPositivo = montoPositivo;
    }

    public String getMontoNegativo() {
        return this.montoNegativo;
    }

    public void setMontoNegativo(String montoNegativo) {
        this.montoNegativo = montoNegativo;
    }

    public String getConceptoMovimiento() {
        return this.conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public String getUsuarioEncargado() {
        return this.usuarioEncargado;
    }

    public void setUsuarioEncargado(String usuarioEncargado) {
        this.usuarioEncargado = usuarioEncargado;
    }

    public static void main(String[] args) {

    }

}

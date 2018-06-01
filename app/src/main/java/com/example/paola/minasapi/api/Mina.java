package com.example.paola.minasapi.api;

public class Mina
{
    private String ano;

    private String codigodanedepartamento;

    private String codigodanemunicipio;

    private String departamento;

    private String evento;

    private String latitudcabecera;

    private String longitudcabecera;

    private String mes;

    private String municipio;

    private String sitio;

    private String tipoarea;

    private String tipoevento;

    private String tipolugar;

    private UbicaciN ubicaciN;


    public Mina(String ano, String codigodanedepartamento, String codigodanemunicipio, String departamento, String evento, String latitudcabecera, String longitudcabecera, String mes, String municipio, String sitio, String tipoarea, String tipoevento, String tipolugar) {
        this.ano = ano;
        this.codigodanedepartamento = codigodanedepartamento;
        this.codigodanemunicipio = codigodanemunicipio;
        this.departamento = departamento;
        this.evento = evento;
        this.latitudcabecera = latitudcabecera;
        this.longitudcabecera = longitudcabecera;
        this.mes = mes;
        this.municipio = municipio;
        this.sitio = sitio;
        this.tipoarea = tipoarea;
        this.tipoevento = tipoevento;
        this.tipolugar = tipolugar;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCodigodanedepartamento() {
        return codigodanedepartamento;
    }

    public void setCodigodanedepartamento(String codigodanedepartamento) {
        this.codigodanedepartamento = codigodanedepartamento;
    }

    public String getCodigodanemunicipio() {
        return codigodanemunicipio;
    }

    public void setCodigodanemunicipio(String codigodanemunicipio) {
        this.codigodanemunicipio = codigodanemunicipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getLatitudcabecera() {
        return latitudcabecera;
    }

    public void setLatitudcabecera(String latitudcabecera) {
        this.latitudcabecera = latitudcabecera;
    }

    public String getLongitudcabecera() {
        return longitudcabecera;
    }

    public void setLongitudcabecera(String longitudcabecera) {
        this.longitudcabecera = longitudcabecera;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getTipoarea() {
        return tipoarea;
    }

    public void setTipoarea(String tipoarea) {
        this.tipoarea = tipoarea;
    }

    public String getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(String tipoevento) {
        this.tipoevento = tipoevento;
    }

    public String getTipolugar() {
        return tipolugar;
    }

    public void setTipolugar(String tipolugar) {
        this.tipolugar = tipolugar;
    }

    public UbicaciN getUbicaciN() {
        return ubicaciN;
    }

    public void setUbicaciN(UbicaciN ubicaciN) {
        this.ubicaciN = ubicaciN;
    }
}

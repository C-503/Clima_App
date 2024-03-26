package com.c503.clima_app.Dominios;

public class Hora {

    private String horas;
    private int temperatura;

    private String picPath;

    public Hora(String horas, int temperatura, String picPath) {
        this.horas = horas;
        this.temperatura = temperatura;
        this.picPath = picPath;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}

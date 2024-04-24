package com.cinefide.domain;

public class ReservaConfirmacion {
    private long tIdReserva;
    private String tnombPelicula;
    private String thoraPelicula;
    private String tasientosPelicula;
    private String tarjeta;
    private String numTarjeta;
    private String pinTarjeta;
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long gettIdReserva() {
        return tIdReserva;
    }

    public void settIdReserva(long tIdReserva) {
        this.tIdReserva = tIdReserva;
    }

    public String getTnombPelicula() {
        return tnombPelicula;
    }

    public void setTnombPelicula(String tnombPelicula) {
        this.tnombPelicula = tnombPelicula;
    }

    public String getThoraPelicula() {
        return thoraPelicula;
    }

    public void setThoraPelicula(String thoraPelicula) {
        this.thoraPelicula = thoraPelicula;
    }

    public String getTasientosPelicula() {
        return tasientosPelicula;
    }

    public void setTasientosPelicula(String tasientosPelicula) {
        this.tasientosPelicula = tasientosPelicula;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public void setPinTarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    @Override
    public String toString() {
        return "ReservaConfirmacion{"
                + "tnombPelicula='" + tnombPelicula + '\''
                + ", thoraPelicula='" + thoraPelicula + '\''
                + ", tasientosPelicula='" + tasientosPelicula + '\''
                + ", tarjeta='" + tarjeta + '\''
                + ", numTarjeta='" + numTarjeta + '\''
                + ", pinTarjeta='" + pinTarjeta + '\''
                + ", tIdReserva='" + tIdReserva + '\''
                + ", correo='" + correo + '\''
                + '}';
    }
}

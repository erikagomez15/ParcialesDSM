package com.example.parcial2.model;

import java.util.ArrayList;

public class Orden {
    private String key;
    private String usuario;
    private String fecha;
    private Articulo articulos;
    private double total;

    public Orden() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Articulo getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo articulos) {
        this.articulos = articulos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

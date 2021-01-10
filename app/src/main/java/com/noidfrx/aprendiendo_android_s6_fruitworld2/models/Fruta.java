package com.noidfrx.aprendiendo_android_s6_fruitworld2.models;

public class Fruta {
    private String nombre, descripcion;
    private int imgBackground, imgIcon, cantidad;

    public static final int LIMITE_CANTIDAD = 10;
    public static final int VALOR_RESET = 0;

    public Fruta() {
    }

    public Fruta(String nombre, String descripcion, int imgBackground, int imgIcon, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgBackground = imgBackground;
        this.imgIcon = imgIcon;
        this.cantidad = cantidad;
    }

    public boolean aumentarCantidad(){
        if(cantidad < LIMITE_CANTIDAD){
            cantidad++;
            return true;
        }
        return false;
    }

    public void resetCantidad(){
        cantidad = VALOR_RESET;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImgBackground() {
        return imgBackground;
    }

    public void setImgBackground(int imgBackground) {
        this.imgBackground = imgBackground;
    }

    public int getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

package com.ab.buscador.modelos;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int anio;
    private int foto;
    private String descripcion;

    private String genero;

    //Constructor
    public Libro(String titulo, String autor, int anio,String genero, String descripcion,int foto) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.foto = foto;
        this.descripcion = descripcion;
        this.genero = genero;

    }
    //Constructor vacio
    public Libro() {
    }


    //Metodos Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

package com.agenda.clases;

public class Persona {

    protected String nombre ;
    protected String apellido;

    public Persona() {
    }

    public Persona( String nombre,String apellido) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

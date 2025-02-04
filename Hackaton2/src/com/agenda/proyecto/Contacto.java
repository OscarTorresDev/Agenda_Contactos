package com.agenda.proyecto;

public  class Contacto {
    private String nombre;
    private String apellido;
    private int numeroContacto;

    public Contacto() {
    }

    public Contacto(String apellido, int numeroContacto, String nombre) {
        if (nombre.isEmpty() || apellido.isEmpty()){
            throw new IllegalArgumentException("Los campos nombre y apellido no pueden estar vacios");
        }
        else {
            this.apellido = apellido;
            this.numeroContacto = numeroContacto;
            this.nombre = nombre;
        }
    }
    ///metodos

    ///metodos
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

    public int getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }


}

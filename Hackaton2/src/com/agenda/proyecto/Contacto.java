package com.agenda.proyecto;

public  class Contacto
{
    private String nombre;
    private String apellido;
    private String telefono; // cambie nombre numero contacto, la rubrica menciona telefono y cambie el tipo por que podria tener indicativo con +

    public Contacto(String nombre, String apellido, String telefono) // Cambie el orden de los parametros
    {
        if (nombre.isEmpty() || apellido.isEmpty()){
            throw new IllegalArgumentException("Los campos nombre y apellido no pueden estar vacios");
        }
        else {
            this.apellido = apellido;
            this.telefono = telefono;
            this.nombre = nombre;
        }
    }

    ///Métodos

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}

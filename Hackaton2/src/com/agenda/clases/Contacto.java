package com.agenda.clases;

public  class Contacto extends Persona {

    private String telefono; // cambie nombre numero contacto, la rubrica menciona telefono y cambie el tipo por que podria tener indicativo con +

    public Contacto(String nombre, String apellido, String telefono) {
        super(nombre, apellido);
        if (nombre.isEmpty() || apellido.isEmpty()){
            throw new IllegalArgumentException("Los campos nombre y apellido no pueden estar vacios");
        }
        else {

            super.apellido = apellido;
            this.telefono = telefono;
            super.nombre = nombre;
        }

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}

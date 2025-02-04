package com.agenda.proyecto;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> agenda;
    private int tamañoMaximo;

    public Agenda() {
        this.agenda = new ArrayList<>();
        this.tamañoMaximo = 10; // Tamaño por defecto es 10
    }

    public boolean añadirContacto(Contacto contacto) {
        if (contacto == null) {
            System.out.println("Error: El contacto no puede ser nulo.");
            return false;
        }
        if (agenda.contains(contacto)) {
            System.out.println("Error: El contacto ya existe en la agenda.");
            return false;
        }
        if (agenda.size() >= tamañoMaximo) {
            System.out.println("Error: La agenda está llena. No se pueden añadir más contactos.");
            return false;
        }
        agenda.add(contacto);
        System.out.println("Contacto añadido correctamente.");
        return true;
    }

    public boolean existeContacto(Contacto contacto) {
        if (contacto == null) {
            return false;
        }
        return agenda.contains(contacto);
    }

    public void listarContactos() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        for (Contacto contacto : agenda) {
            System.out.println(contacto);
        }
    }

    public void buscaContacto(String nombre, String apellido) {
        Contacto contactoBuscado = new Contacto(nombre, apellido, 0);
        if (agenda.contains(contactoBuscado)) {
            for (Contacto contacto : agenda) {
                if (contacto.equals(contactoBuscado)) {
                    System.out.println("Contacto encontrado: " + contacto);
                    return;
                }
            }
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public boolean eliminarContacto(Contacto contacto) {
        if (contacto == null) {
            System.out.println("Error: El contacto no puede ser nulo.");
            return false;
        }
        if (agenda.remove(contacto)) {
            System.out.println("Contacto eliminado correctamente.");
            return true;
        } else {
            System.out.println("Error: El contacto no existe en la agenda.");
            return false;
        }
    }

    public boolean modificarTelefono(String nombre, String apellido, int nuevoTelefono) {
        Contacto contactoAModificar = new Contacto(nombre, apellido, 0);
        if (!agenda.contains(contactoAModificar)) {
            System.out.println("Error: El contacto no existe en la agenda.");
            return false;
        }
        for (Contacto contacto : agenda) {
            if (contacto.equals(contactoAModificar)) {
                contacto.setNumeroContacto(nuevoTelefono);
                System.out.println("Teléfono modificado correctamente.");
                return true;
            }
        }
        return false;
    }

    public boolean agendaLlena() {
        return agenda.size() >= tamañoMaximo;
    }

    public int espacioLibres() {
        return tamañoMaximo - agenda.size();
    }
}
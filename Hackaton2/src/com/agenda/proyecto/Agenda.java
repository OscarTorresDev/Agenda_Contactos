package com.agenda.proyecto;

import java.util.ArrayList;

public class Agenda extends Contacto{

    ArrayList<Contacto> agenda = new ArrayList<>();

    public Agenda() {
    }

    public Agenda(String apellido, int numeroContacto, String nombre) {
        super(apellido, numeroContacto, nombre);
    }

    public void anadirContacto (Contacto contactoNuevo) {
        boolean agendaLlena;
        if (agenda.size() > 10) {
            System.out.println("No es posible agregar contacto agenda llena");
            agendaLlena = false;
        } else {
            agendaLlena = false;
            if (agenda.contains(contactoNuevo)) {
                System.out.println("el contacto ya existe");
            } else {
                agenda.add(contactoNuevo);
                System.out.println("Contacto agregado");
            }
        }
    }
        public void mostrarDatos(){
            for (Contacto contacto : agenda){
                System.out.println("\nombre :" + contacto.getNombre());
                System.out.println("Apellido :" + contacto.getApellido());
                System.out.println("Apellido :" + contacto.getNumeroContacto());
            }
        }

        public ArrayList<Contacto> getAgenda() {
            return agenda;
        }

        public void setAgenda(ArrayList<Contacto> agenda) {
            this.agenda = agenda;
        }

    }


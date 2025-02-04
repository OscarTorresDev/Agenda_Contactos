package com.agenda.proyecto;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> agenda = new ArrayList<>();
    private int tamanioAgenda;
    public Agenda() {
    }

    public Agenda(int tamanioAgenda) {
        if (tamanioAgenda==0){
            this.tamanioAgenda = 10;
        }else{
            this.tamanioAgenda = tamanioAgenda;
        }
    }

    public void anadirContacto (Contacto contactoNuevo) {
        if(agendaLlena()){
            if (agenda.contains(contactoNuevo)) {
                System.out.println("el contacto ya existe");
            } else {
                agenda.add(contactoNuevo);
                System.out.println("........Contacto agregado");
            }
        }
        else{
            System.out.println("No es posible agregar mas contactos ¡agenda llena!");
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

    public int getTamanioAgenda() {
        return tamanioAgenda;
    }

    public void setTamanioAgenda(int tamanioAgenda) {
            this.tamanioAgenda = tamanioAgenda;
    }

    // Método para listar contactos por orden alfabético

    public void listarContactos() {
        if (agenda.isEmpty()) {
            System.out.println("No hay contactos en la agenda");
            return;
        }
        for (int i = 0; i < agenda.size(); i++) {
            for (int j = i + 1; j < agenda.size(); j++) {
                Contacto c1 = agenda.get(i);
                Contacto c2 = agenda.get(j);

                String nombreCompleto1 = c1.getNombre().toLowerCase() + c1.getApellido().toLowerCase();
                String nombreCompleto2 = c2.getNombre().toLowerCase() + c2.getApellido().toLowerCase();
                if (nombreCompleto1.compareTo(nombreCompleto2) > 0) {
                    agenda.set(i, c2);
                    agenda.set(j, c1);
                }
            }
        }
        for (Contacto contacto : agenda) {
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumeroContacto());
        }
    }

    // Método para agenda llena

    public boolean agendaLlena(){
        if (agenda.size() > tamanioAgenda - 1) {
            //No es posible agregar mas contactos agenda llena
            return false;
        }
        else {
            //Aun cuenta con espacios disponibles
            return true;
        }
    }
}


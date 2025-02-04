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
}


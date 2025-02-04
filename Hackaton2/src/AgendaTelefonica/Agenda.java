package AgendaTelefonica;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> agenda = new ArrayList<>();
    private int tamanioAgenda= 10;

    public void agenda() {
    }
    public int getTamanioAgenda() {
        return tamanioAgenda;
    }

    public void agenda(ArrayList<Contacto> agenda) {
        this.agenda = agenda;
    }

    // Getters y setters
    public ArrayList<Contacto> getAgenda() {
        return agenda;
    }
    public void setAgenda(ArrayList<Contacto> agenda) {
        this.agenda = agenda;
    }


    //Metodo Añadir Contacto
    public void anadirContacto (Contacto contactoNuevo) {
        boolean agendaLlena;
        if (agenda.size() >= tamanioAgenda) {
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

    // Método verificar si existe un contacto
    public boolean existeContacto( ArrayList<Contacto> agenda, String nombre, String apellido){
        boolean existe = false;
        for(Contacto contacto:  agenda){
            if(contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)){
                existe = true;
            }else{
                existe = false;
            }
        }
        return existe;
    }

    public void mostrarDatos(){
        for (Contacto contacto : agenda){
            System.out.println("\nombre :" + contacto.getNombre());
            System.out.println("Apellido :" + contacto.getApellido());
            System.out.println("Apellido :" + contacto.getNumeroContacto());
        }
    }


    // Mostrar lista de contactos
    public static void listarContactos(ArrayList<Contacto> agenda){
        if (agenda.isEmpty()) {
            System.out.println("No hay contactos en la lista.");
        } else {
            System.out.println("Lista de contactos:");
            System.out.println("_____________________");
            for (Contacto contacto : agenda) {
                System.out.println("\nombre :" + contacto.getNombre());
                System.out.println("Apellido :" + contacto.getApellido());
                System.out.println("Apellido :" + contacto.getNumeroContacto());
            }
        }
    }

    public static Contacto buscaContacto( ArrayList<Contacto> agenda, String nombre, String apellido){
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }


    // Método para verificar si hay espacios disponibles en la agenda
    public static int espacioLibres( ArrayList<Contacto> agenda, int tamanioAgenda){
        return tamanioAgenda - agenda.size();
    }

}
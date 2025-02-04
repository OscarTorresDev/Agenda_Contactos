package com.agenda.clases;

import java.util.ArrayList;

public class Agenda
{
  private ArrayList<Contacto> listaContactos;

  int tamañoMaximo;

    public Agenda(int tamañoAgenda)
    {
        this.listaContactos = new ArrayList<>();
        this.tamañoMaximo = tamañoAgenda;
    }

    public void anadirContacto(Contacto c)
    {
        if (this.agendaLlena())
        {
            System.out.println("ERROR: La agenda está llena. No se puede añadir el contacto.");
            return;
        }

        if (existeContacto(c))
        {
            System.out.println("ERROR: Ya existe un contacto con ese nombre y apellido.");
            return;
        }

        // Si pasa todas las validaciones Y agregar a la lista

        // c es el contacto que se esta agregando que es la instancia de contacto
        listaContactos.add(c);
        System.out.println("Contacto añadido con éxito: "
                + c.getNombre() + " " + c.getApellido());
    }

    // Se lista todos los contactos

    public void listarContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda");
            return;

        }
        for (int i = 0; i < listaContactos.size(); i++) {
            for (int j = i + 1; j < listaContactos.size(); j++) {
                Contacto c1 = listaContactos.get(i);
                Contacto c2 = listaContactos.get(j);

                String nombreCompleto1 = c1.getNombre().toLowerCase() + c1.getApellido().toLowerCase();
                String nombreCompleto2 = c2.getNombre().toLowerCase() + c2.getApellido().toLowerCase();
                if (nombreCompleto1.compareTo(nombreCompleto2) > 0) {

                    listaContactos.set(i, c2);
                    listaContactos.set(j, c1);
                }
            }
        }

        for (Contacto contacto : listaContactos) {
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getTelefono());
        }
    }

    // Buscar un contacto por nombre y apellido

    public String buscarContacto(String nombre, String apellido)
    {
        for (Contacto c : listaContactos)
        {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido))
            {
                return c.getTelefono();
            }
        }
        return null; // si no se encuentra el contacto
    }

    // Eliminar un contacto

    public void eliminarContacto(Contacto c)
    {
        for (int i = 0; i < listaContactos.size(); i++)
        {
            Contacto actual = listaContactos.get(i); // actaul es el contacto en la posición de i
            if (actual.getNombre().equalsIgnoreCase(c.getNombre()) && actual.getApellido().equalsIgnoreCase(c.getApellido()))
            {
                listaContactos.remove(i);
                System.out.println("El contacto ha sido eliminado con éxito.");
                return;
            }
        }
        System.out.println("El contacto que intentas eliminar no existe en la agenda.");
    }

    // Modificar el teléfono de un contacto existente

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono)
    {
        for (Contacto c : listaContactos) // itero la lista de contactos, c va tomando la instancia del contacto actual
        {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido))
            {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono modificado correctamente.");
                return;
            }
        }
        System.out.println("El contacto no existe, no se pudo modificar el teléfono.");
    }
    public int espaciosLibres()
    {
        return tamañoMaximo - listaContactos.size();

    } // resta 10 de los contactos de la lista para obtener los espacios

    public boolean agendaLlena()
    {
        return listaContactos.size() >= tamañoMaximo;
    }

    public boolean existeContacto(Contacto c)
    {
        // Quita los espacios a los datos ingresados

        String tempNombre = c.getNombre().trim();
        String tempApellido = c.getApellido().trim();

        // Se verifica si alguno coincide

        for (Contacto existente : listaContactos)
        {
            if (existente.getNombre().equalsIgnoreCase(tempNombre) && existente.getApellido().equalsIgnoreCase(tempApellido)) {
                return true;
            }
        }
        return false;
    }
}






package com.agenda.proyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion = 0;
        do {
            System.out.println("""
                    \nMenú:
                    1) Añadir contacto.
                    2) Verificar si existe un contacto.
                    3) Listar contactos.
                    4) Buscar contacto por nombre y apellido.
                    5) Eliminar contacto.
                    6) Modificar teléfono de un contacto.
                    7) Verificar si la agenda está llena.
                    8) Ver espacios libres en la agenda.
                    9) Salir.
                    """);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena. No se pueden añadir más contactos.");
                        break;
                    }
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    int telefono = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Contacto contacto = new Contacto(nombre, apellido, telefono);
                        agenda.añadirContacto(contacto);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombreExiste = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoExiste = scanner.nextLine();
                    Contacto contactoExiste = new Contacto(nombreExiste, apellidoExiste, 0);
                    if (agenda.existeContacto(contactoExiste)) {
                        System.out.println("El contacto existe en la agenda.");
                    } else {
                        System.out.println("El contacto no existe en la agenda.");
                    }
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    String nombreBuscar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoBuscar = scanner.nextLine();
                    agenda.buscaContacto(nombreBuscar, apellidoBuscar);
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    String nombreEliminar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoEliminar = scanner.nextLine();
                    Contacto contactoEliminar = new Contacto(nombreEliminar, apellidoEliminar, 0);
                    agenda.eliminarContacto(contactoEliminar);
                    break;
                case 6:
                    System.out.print("Nombre: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoModificar = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    int nuevoTelefono = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    agenda.modificarTelefono(nombreModificar, apellidoModificar, nuevoTelefono);
                    break;
                case 7:
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("La agenda no está llena.");
                    }
                    break;
                case 8:
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 9);
        scanner.close();
    }
}
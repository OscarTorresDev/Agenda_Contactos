package com.agenda.proyecto;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Usamos siempre la cantidad fija de 10

        int opcion = 0;

        System.out.println("\n===== BIENVENIDO A NUESTRA AGENDA TELEFÓNICA =====");
        System.out.println("Deseas configurar el tamaño de la agenda si/no: ");
        String configAgenda = sc.nextLine();
        int tamañoAgenda = 10;

        if (configAgenda.equalsIgnoreCase("si"))
        {
            System.out.println("Digita el tamaño de la agenda: ");
            tamañoAgenda = sc.nextInt();
        }

        Agenda agenda = new Agenda(tamañoAgenda);

        do
        {
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar si existe un contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto (obtener teléfono)");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono de un contacto");
            System.out.println("7. Verificar si la agenda está llena");
            System.out.println("8. Ver espacios libres");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // para limpiar el scanner y funcione el menu

            switch (opcion)
            {
                case 1:
                    System.out.println("=== Añadir Contacto ===");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    try {
                        Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
                        agenda.anadirContacto(nuevoContacto);
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:
                    System.out.println("=== Verificar Contacto ===");
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();

                    // Creamos un contacto temporal para ver si existe

                    Contacto tempContacto = new Contacto(nombre, apellido, "");
                    if (agenda.existeContacto(tempContacto))
                    {
                        System.out.println("\nEl contacto SÍ existe en la agenda.");
                    } else {
                        System.out.println("\nEl contacto NO existe en la agenda.");
                    }
                    break;

                case 3:
                    System.out.println("=== Listar Contactos ===");
                    agenda.listarContactos();
                    break;

                case 4:
                    System.out.println("=== Buscar Contacto ===");
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    String tel = agenda.buscarContacto(nombre, apellido);

                    if (tel != null) {
                        System.out.println("\nTeléfono encontrado: " + tel);
                    } else {
                        System.out.println("\nNo se ha encontrado el contacto.");
                    }
                    break;

                case 5:
                    System.out.println("=== Eliminar Contacto ===");
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();

                    // Teléfono no es relevante para eliminar, pero necesitamos el objeto

                    Contacto contactoAEliminar = new Contacto(nombre, apellido, "");
                    agenda.eliminarContacto(contactoAEliminar);
                    break;

                case 6:
                    System.out.println("=== Modificar Teléfono ===");
                    System.out.print("Nombre del contacto: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido del contacto: ");
                    apellido = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    telefono = sc.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;

                case 7:
                    if (agenda.agendaLlena()) {
                        System.out.println("\nLa agenda está llena. No hay más espacio.");
                    } else {
                        System.out.println("\nLa agenda NO está llena.");
                    }
                    break;

                case 8:
                    System.out.println("\nQuedan " + agenda.espaciosLibres() + " espacios libres en la agenda.");
                    break;

                case 9:
                    System.out.println("\nSaliendo del programa... ¡Gracias por usar nuestra Agenda!");
                    break;

                default:
                    System.out.println("\nOpción inválida. Por favor, selecciona una opción válida.");
                    break;
            }

        } while (opcion != 9);

        sc.close();
    }
}

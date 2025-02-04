package com.agenda.proyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("            Bienvenido");
        System.out.print("Digite el tamaño de la agenda o 0 para dejar el tamaño por defecto : ");
        int tamanioAgenda = scanner.nextInt();
        Agenda agenda = new Agenda();
        agenda.setTamanioAgenda(tamanioAgenda);
        int opcion = 0;
        do {
            System.out.println("""
                      \n
                                Menu
                       1) Añadir contacto.
                       2) Mostrar Agenda
                       3) Salir.     
                    """);
            opcion = scanner.nextInt();

                switch (opcion){
                    case 1 :
                        if (agenda.agendaLlena()) {
                            System.out.println("Digite el nombre : ");
                            String nombre = scanner.next();
                            System.out.println("Digite el apellido : ");
                            String apellido = scanner.next();
                            System.out.println("Digite el telefono : ");
                            int telefono = scanner.nextInt();

                            Contacto contacto = new Contacto(apellido, telefono, nombre);
                            agenda.anadirContacto(contacto);
                        }
                        else {
                            System.out.println("¡Agenda llena!");
                        }
                        break;
                    case 2 :
                         agenda.mostrarDatos();
                        break;
                    case 3 :
                        System.out.println("Hasta pronto");;
                        break;
                    default:
                        System.out.println("Digite una opcion valida");
                }

        }while (opcion != 3);
        System.out.println("Fin del programa");

    }
}
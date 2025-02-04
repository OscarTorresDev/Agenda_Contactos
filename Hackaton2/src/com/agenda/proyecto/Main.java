package com.agenda.proyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion = 0;
        do {
            System.out.println("""
                            \nMenu
                       1) Añadir contacto.
                       2) Mostrar Agenda
                       3) Salir.     
                    """);
            opcion = scanner.nextInt();

                switch (opcion){
                    case 1 :
                        System.out.println("Digite el nombre : ");
                        String nombre = scanner.next();
                        System.out.println("Digite el apellido : ");
                        String apellido = scanner.next();
                        System.out.println("Digite el telefono : ");
                        int telefono = scanner.nextInt();
                        Contacto contacto= new Contacto(apellido,telefono,nombre);
                        agenda.anadirContacto(contacto);
                        break;
                    case 2 :
                        agenda.mostrarDatos();
                        break;
                    default:
                        System.out.println("Digite una opcion valida");
                }

        }while (opcion != 3);
        System.out.println("Fin del programa");

    }
}
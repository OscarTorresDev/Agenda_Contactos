package AgendaTelefonica;

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
                       3) Verificar si existe un contacto.
                       4) Buscar un contacto por nombre y apellido.
                       5) Espacios libres en la agenda.
                       6) Salir.
                    """);
            System.out.print("Seleccione una opción: ");
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
                case 3:
                    System.out.print("Digite el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.next();
                    System.out.print("Digite el apellido del contacto a buscar: ");
                    String apellidoBuscar = scanner.next();

                    boolean existe = agenda.existeContacto(agenda.getAgenda(), nombreBuscar, apellidoBuscar);
                    if (existe) {
                        System.out.println("El contacto " + nombreBuscar + " " + apellidoBuscar + " existe en la agenda.");
                    } else {
                        System.out.println("El contacto no existe en la agenda.");
                    }
                    break;

                case 4:
                    System.out.print("Digite el nombre del contacto a buscar: ");
                    String nombreBusqueda = scanner.next();
                    System.out.print("Digite el apellido del contacto a buscar: ");
                    String apellidoBusqueda = scanner.next();

                    Contacto encontrado = agenda.buscaContacto(agenda.getAgenda(), nombreBusqueda, apellidoBusqueda);
                    if (encontrado != null) {
                        System.out.println("Contacto encontrado:");
                        System.out.println("Nombre: " + encontrado.getNombre());
                        System.out.println("Apellido: " + encontrado.getApellido());
                        System.out.println("Teléfono: " + encontrado.getNumeroContacto());
                    } else {
                        System.out.println("El contacto no fue encontrado.");
                    }
                    break;

                case 5:
                    int espaciosLibres = Agenda.espacioLibres(agenda.getAgenda(), agenda.getTamanioAgenda());
                    System.out.println("Espacios libres en la agenda: " + espaciosLibres);
                    break;

                case 6:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Por favor, seleccione una opción válida.");
            }

        }while (opcion != 3);
        System.out.println("Fin del programa");
        scanner.close();
    }
}


package ejerciciosCalificados04;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner; 
public class Main {
    private static final Scanner cs = new Scanner(System.in);
    public static void main(String[] args) {
        int accion; 
        Estudiantes2023 estudiantes = new Estudiantes2023();
        

        System.out.print("****** BIENVENIDOS AL SISTEMA DE GESTION DE ESTUDIANTES ******\n");
        try {
            
            do {
                
                System.out.print("1-NUEVO ESTUDIANTE\n" +
                "2-BUSCAR ESTUDIANTE\n" +
                "3-ELIMINAR ESTUDIANTE\n" +
                "4-MODIFICAR ESTUDIANTE\n" +
                "5-MODIFICAR APELLIDOS EN MINÚSCULAS.\n" +
                "6-VER TODOS LOS ESTUDIANTES\n" +
                "7-VER TODOS LOS ESTUDIANTES POR APELLIDOS\n" +
                "8-VER TODOS LOS ESTUDIANTES POR PENSIÓN\n" +
                "9-TOTAL DE PENSIONES\n" +
                "10-SALIR\n" + 
                "    ¿QUÉ ACCIONE DESEA EJECUTAR?\n");
                accion = cs.nextInt();
                while (accion<0 || accion >10 ) {
                    System.out.println("Ingresa nuevamente un valor valido: ");
                    accion=cs.nextInt();
                }
                switch (accion) {
                    case 1: 
                        System.out.println("****** REGISTRAR A UN NUEVO ESTUDIANTE ********");
                        break;

                    case 2: 
                        break;

                    case 3: 
                        break;

                    case 4: 
                        break;

                    case 5: 
                        break;

                    case 6:
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarEstudiantes();
                        System.out.println("-----------------------------------------------------------------------------------");
                        break;

                    case 7: 
                        break;

                    case 8: 
                        break;

                    case 9: 
                        break;

                    default:
                        break;
                } 
            } while (accion<0 || accion >10);    
        } catch (Exception e) {
            System.out.println("ERROR! ");
        }
    }
}
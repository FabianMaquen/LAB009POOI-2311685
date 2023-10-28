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
                    Scanner sc = new Scanner(System.in);

                    	System.out.println("** BUSCAR A UN ESTUDIANTE ****");
                    	System.out.println("PUEDE BUSCAR POR NOMBRE O CODIGO. ELEGIR UNA OPCIÓN:");
                    	System.out.println("A – APELLIDO");
                    	System.out.println("B – CODIGO");

                    	char opcion = sc.nextLine().charAt(0);

                    	if (opcion == 'A') {
                    	    System.out.println("INGRESE EL APELLIDO DEL ALUMNO:");
                    	    String nombre = sc.nextLine();
                    	    
                    	    Estudiante estudianteEncontrado = estudiantes.buscarNombre(nombre);
                            
                            if (estudianteEncontrado != null) {
                                System.out.println("El alumno es: " + estudianteEncontrado.getNombre());
                            } else {
                                System.out.println("El alumno no está registrado.");
                            }
                    	 

                    	} else if (opcion == 'B') {
                    	    System.out.println("INGRESE EL CÓDIGO DEL ALUMNO:");

                    	    try {
                    	        int codigo = Integer.parseInt(sc.nextLine());

                    	        Estudiante estudianteEncontrado = estudiantes.buscar(codigo);

                    	        if (estudianteEncontrado != null) {
                    	            System.out.println("El alumno es: " + estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getCodigo());
                    	        } else {
                    	            System.out.println("El alumno no está registrado.");
                    	        }
                    	    } catch (NumberFormatException e) {
                    	        System.out.println("Error con el codigo del alumno: " + e.getMessage());
                    	    }
                    	} else {
                    	    System.out.println("Opción no válida.");
                    	}
                    
                        break;

                    case 3: 
                        break;

                    case 4: 
                    
                        break;

                    case 5: 
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                    System.out.println("-----------------------------------------------------------------------------------");
                    estudiantes.listarEstudiantes();
                    System.out.println("-----------------------------------------------------------------------------------");
                    
                    estudiantes.modificarApellidos();
                    System.out.println("LA NUEVA LISTA:");
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                    System.out.println("-----------------------------------------------------------------------------------");
                    estudiantes.listarEstudiantes();
                    System.out.println("-----------------------------------------------------------------------------------");
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
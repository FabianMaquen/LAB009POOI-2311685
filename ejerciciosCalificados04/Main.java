package ejerciciosCalificados04;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner; 
public class Main {
    private static final Scanner cs = new Scanner(System.in);
    public static void main(String[] args) {
        int accion; 
        Estudiantes2023 estudiantes = new Estudiantes2023();
        

        System.out.print("** BIENVENIDOS AL SISTEMA DE GESTION DE ESTUDIANTES **\n");
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
                "    ¿QUÉ ACTIVIDAD DESEA EJECUTAR?\n");
                
                accion = cs.nextInt();
                while (accion<=0 || accion >10 ) {
                    System.out.println("Ingresa nuevamente un valor valido: ");
                    accion=cs.nextInt();
                }
                switch (accion) {
                    case 1: 
                        System.out.println("****** REGISTRAR A UN NUEVO ESTUDIANTE ********");

<<<<<<< HEAD
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
                    
=======
                        String nombre, apellidos, nombre_Y_apellido;
                        int ciclo;
                        double pension;

                        try {
                            System.out.print("INGRESE NOMBRES: ");
                            cs.nextLine();
                            nombre = cs.nextLine();
                            
                            System.out.print("INGRESE APELLIDOS: ");
                            apellidos = cs.nextLine();

                            nombre_Y_apellido = nombre + " " + apellidos;
                            
                            System.out.print("INGRESE CICLO: ");
                            ciclo = cs.nextInt();
                            
                            System.out.print("INGRESE PENSION: "); 
                            pension = cs.nextDouble();
                            
                            // Crear el código único para el nuevo estudiante
                            int codigo = estudiantes.tamano() + 101;
                            
                            
                            Estudiante nuevoEstudiante = new Estudiante(codigo, nombre_Y_apellido, ciclo, pension);
                            estudiantes.adicionar(nuevoEstudiante);
                            
                            System.out.println("¡Se añadió con éxito!");
                            
                        } catch (Exception e) {
                            System.out.println("Error al ingresar valores. Asegúrese de ingresar valores válidos.");
                        }

                    case 2:

>>>>>>> 471c39b31055dc24abe2d5865fcaef0e6efd6ae4
                        break;

                    case 3: 
                        break;

                    case 4: 
<<<<<<< HEAD
                    
                        break;
=======
                        System.out.println("****** MODIFICACIÓN  DE ESTUDIANTE ********");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarEstudiantes();
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.print("INDIQUE EL CODIGO DEL ESTUDIANTE A MODIFICAR: ");
>>>>>>> 471c39b31055dc24abe2d5865fcaef0e6efd6ae4

                        int buscarcodigo = cs.nextInt();

                        // CAMBIAR NOMBRES Y APELLIDOS 
                        System.out.print("INGRESE NOMBRES: ");
                        String nuevoNombre = cs.next();
                        System.out.print("INGRESE APELLIDOS: ");
                        String nuevoApellido= cs.next();
                        String nombreYapellido = nuevoNombre +" " +  nuevoApellido;
                        estudiantes.buscar(buscarcodigo).setNombre(nombreYapellido);
                        //CICLO
                        System.out.print("INGRESE CICLO: ");
                        int nuevoCiclo= cs.nextInt();
                        estudiantes.buscar(buscarcodigo).setCiclo(nuevoCiclo);

                        //PENSION
                        System.out.print("INGRESE PENSIÓN: ");
                        double nuevaPension= cs.nextDouble();
                        estudiantes.buscar(buscarcodigo).setPension(nuevaPension);
                        System.out.println("¡Se modificó con éxito!");
                        estudiantes.listarEstudiantes();
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
                        System.out.println("\n\n****** SUMATORIA DE PENSIONES ********");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarEstudiantes();
                        System.out.println("-----------------------------------------------------------------------------------");

                        double sumaPensiones = 0.0;
                        for (int i = 0; i < estudiantes.tamano(); i++) {
                            Estudiante estudiante = estudiantes.obtener(i);
                            sumaPensiones += estudiante.getPension();
                        }

                        System.out.printf("LA SUMA TOTAL ES: S/ %.2f%n", sumaPensiones );
                        break;

                    default:
                        break;
                } 
            } while (accion>0 || accion <9);    
        } catch (Exception e) {
            System.out.println("ERROR! ");
        }
    }
}
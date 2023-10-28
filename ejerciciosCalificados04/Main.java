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

                        break;
                    case 2: 
                    
                        break;
                    case 3: 
                        break;
                    case 4: 
                        System.out.println("****** MODIFICACIÓN  DE ESTUDIANTE ********");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarEstudiantes();
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.print("INDIQUE EL CODIGO DEL ESTUDIANTE A MODIFICAR: ");

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
            } while (accion>0 || accion <9);    
        } catch (Exception e) {
            System.out.println("ERROR! ");
        }
    }
}